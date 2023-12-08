package br.com.saborexpress.payments.presentation.api.v1.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentRequestDTO {

    @NotNull
    private BigDecimal value;

    @NotNull
    @Valid
    private CardRequestDTO card;

    @NotNull
    private Long orderId;

    @NotNull
    private Long paymentMethodId;

}
