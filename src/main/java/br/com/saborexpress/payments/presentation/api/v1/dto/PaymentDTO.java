package br.com.saborexpress.payments.presentation.api.v1.dto;

import br.com.saborexpress.payments.business.model.enumeration.Status;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public class PaymentDTO {

    private UUID id;

    private BigDecimal value;

    private Status.StatusDTO status;

    private CardDTO card;

    private Long orderId;

    private Long paymentMethodId;
}
