package br.com.saborexpress.payments.presentation.api.v1.dto.assembler;

import br.com.saborexpress.payments.business.model.Payment;
import br.com.saborexpress.payments.presentation.api.v1.dto.PaymentDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentAssembler implements Assembler<Payment, PaymentDTO> {

    private final ModelMapper mapper;

    @Override
    public PaymentDTO toDTO(Payment entity) {
        var paymentDTO = mapper.map(entity, PaymentDTO.class);

        paymentDTO.setStatus(entity.getStatus().toDTO());

        return paymentDTO;
    }
}
