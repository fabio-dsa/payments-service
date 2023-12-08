package br.com.saborexpress.payments.business.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Card {

    @Column(name = "card_name")
    private String name;

    @Column(name = "card_number")
    private String number;

    @Column(name = "card_expiration")
    private String expiration;

    @Column(name = "card_code")
    private String code;

    public void setNumber(String number) {
        this.number = number.replaceAll("\\D", "");
    }
}
