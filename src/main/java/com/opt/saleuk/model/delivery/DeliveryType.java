package com.opt.saleuk.model.delivery;

/**
 * Created by Arizel on 29.12.2017.
 */
public enum DeliveryType {
    PICKUP("Pickup"),
    COURIER("Courier");

    DeliveryType(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }
}
