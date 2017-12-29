package com.opt.saleuk.model.types;

/**
 * Created by Arizel on 29.12.2017.
 */
public enum ProductType {
    FRUIT("Fruit"),
    VEGETABLES("Vegetables"),
    CEREALS("Cereals");

    ProductType(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }
}
