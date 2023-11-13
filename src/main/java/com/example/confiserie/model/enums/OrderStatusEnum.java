package com.example.confiserie.model.enums;

public enum OrderStatusEnum {
    PAID("The order is fully paid. There is no balance due nor any refund."),
    RETURNED("A return is the act of sending back an order after delivery to the recipient. Return may be due to repair, cancellation, complaint or wrong delivery."),
    CLOSED("An order is in closed status when all of the transactions have been completed (i.e., the items have been received and invoiced). An order is in cancelled status when the entire order is cancelled."),
    ARCHIVED("Archived orders are orders which should generally not be shipped. These orders are either cancelled or in an unknown state such as when your sales channel no longer sends updates for them to us implying that it is no longer fulfillable.");

    private final String value;

    OrderStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
