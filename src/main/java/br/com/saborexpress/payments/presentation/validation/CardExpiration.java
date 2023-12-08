package br.com.saborexpress.payments.presentation.validation;

import br.com.saborexpress.payments.presentation.validation.validator.CardExpirationValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CardExpirationValidator.class)
public @interface CardExpiration {

    String message() default "Invalid card expiration. The expected pattern is MM/yyyy";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
