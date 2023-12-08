package br.com.saborexpress.payments.presentation.api.v1.controller;

import br.com.saborexpress.payments.business.service.PaymentService;
import br.com.saborexpress.payments.presentation.api.v1.dto.PaymentDTO;
import br.com.saborexpress.payments.presentation.api.v1.dto.assembler.PaymentAssembler;
import br.com.saborexpress.payments.presentation.api.v1.dto.disassembler.PaymentDisassembler;
import br.com.saborexpress.payments.presentation.api.v1.dto.page.CustomPage;
import br.com.saborexpress.payments.presentation.api.v1.dto.request.PaymentRequestDTO;
import br.com.saborexpress.payments.presentation.api.v1.openapi.PaymentOpenApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/payments")
@RequiredArgsConstructor
public class PaymentController implements PaymentOpenApi {

    private final PaymentService paymentService;

    private final PaymentAssembler paymentAssembler;

    private final PaymentDisassembler paymentDisassembler;

    @Override
    @GetMapping
    public CustomPage<PaymentDTO> findAll(Pageable pageable) {
        return this.paymentAssembler.toDTOPage(this.paymentService.findAll(pageable));
    }

    @Override
    @GetMapping("/{id}")
    public PaymentDTO findById(@PathVariable String id) {
        return this.paymentAssembler.toDTO(this.paymentService.findById(UUID.fromString(id)));
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid PaymentRequestDTO paymentRequestDTO) {
        this.paymentService.create(this.paymentDisassembler.toEntity(paymentRequestDTO));
    }

    @Override
    @PostMapping("/{id}/confirmations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void confirm(@PathVariable String id) {
        this.paymentService.confirm(UUID.fromString(id));
    }

    @Override
    @PostMapping("/{id}/cancellations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancel(@PathVariable String id) {
        this.paymentService.cancel(UUID.fromString(id));
    }
}
