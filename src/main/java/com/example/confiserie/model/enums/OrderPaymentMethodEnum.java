package com.example.confiserie.model.enums;

public enum OrderPaymentMethodEnum {
    CASH("Cash"),
    CARD("Card"),
    BREUNINGER_CARD("Breuninger Card");
    private final String value;

    OrderPaymentMethodEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
