package br.com.saborexpress.payments.business.model.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Status {

    CREATED("Created"),
    CONFIRMED("Confirmed"),
    CANCELED("Canceled");

    private final String label;

    public StatusDTO toDTO() {
        return new StatusDTO(this);
    }

    @Getter
    public static class StatusDTO {
        private final String key;

        private final String label;

        public StatusDTO(Status status) {
            this.key = status.name();
            this.label = status.getLabel();
        }
    }
}
