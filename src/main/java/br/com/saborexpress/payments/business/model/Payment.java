package br.com.saborexpress.payments.business.model;

import br.com.saborexpress.payments.business.model.enumeration.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    private UUID id;

    private BigDecimal value;

    @Embedded
    private Card card;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "payment_method_id")
    private Long paymentMethodId;

    @PrePersist
    private void onCreate() {
        this.id = UUID.randomUUID();
    }
}
