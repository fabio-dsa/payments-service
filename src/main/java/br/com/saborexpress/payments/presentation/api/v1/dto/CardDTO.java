package br.com.saborexpress.payments.presentation.api.v1.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class CardDTO {

    private String name;

    private String number;

    public String getNumber() {
        return StringUtils.overlay(this.number, "********", 4, 12);
    }
}
