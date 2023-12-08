package br.com.saborexpress.payments.presentation.api.v1.dto.request;

import br.com.saborexpress.payments.presentation.validation.CardExpiration;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;

@Getter
@Setter
public class CardRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    @CreditCardNumber(ignoreNonDigitCharacters = true)
    private String number;

    @NotBlank
    @CardExpiration
    private String expiration;

    @NotBlank
    @Size(min = 3, max = 3)
    private String code;

}
