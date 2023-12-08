package br.com.saborexpress.payments.presentation.validation.validator;

import br.com.saborexpress.payments.presentation.validation.CardExpiration;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class CardExpirationValidator implements ConstraintValidator<CardExpiration, String> {

    private static final String PATTERN = "^(0[1-9]|1[0-2])/[1-9]\\d{3}$";

    @Override
    public void initialize(CardExpiration constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.isNotBlank(s) && Pattern.compile(PATTERN).matcher(s).matches();
    }

}
