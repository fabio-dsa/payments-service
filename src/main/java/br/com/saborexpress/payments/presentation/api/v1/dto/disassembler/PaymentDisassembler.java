package br.com.saborexpress.payments.presentation.api.v1.dto.disassembler;

import br.com.saborexpress.payments.business.model.Payment;
import br.com.saborexpress.payments.presentation.api.v1.dto.request.PaymentRequestDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentDisassembler implements Disassembler<PaymentRequestDTO, Payment> {

    private final ModelMapper mapper;

    @Override
    public Payment toEntity(PaymentRequestDTO dto) {
        return this.mapper.map(dto, Payment.class);
    }
}
