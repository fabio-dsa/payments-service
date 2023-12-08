package br.com.saborexpress.payments.business.service;

import br.com.saborexpress.payments.business.exception.ResourceNotFoundException;
import br.com.saborexpress.payments.business.model.Payment;
import br.com.saborexpress.payments.business.model.enumeration.Status;
import br.com.saborexpress.payments.integration.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Page<Payment> findAll(Pageable pageable) {
        return this.paymentRepository.findAll(pageable);
    }

    public Payment findById(UUID uuid) {
        return this.paymentRepository
                .findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("No payment found with id ".concat(uuid.toString())));
    }

    public Payment create(Payment payment) {
        payment.setStatus(Status.CREATED);
        return this.paymentRepository.save(payment);
    }

    public void cancel(UUID uuid) {
        var payment = this.findById(uuid);
        payment.setStatus(Status.CANCELED);
        this.paymentRepository.save(payment);
    }

    public void confirm(UUID uuid) {
        var payment = this.findById(uuid);
        payment.setStatus(Status.CONFIRMED);
        this.paymentRepository.save(payment);
    }
}
