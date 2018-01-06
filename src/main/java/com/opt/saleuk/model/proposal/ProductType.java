package com.opt.saleuk.model.proposal;

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

    @Override
    public String toString() {
        return "ProductType{" +
                "firstName='" + name + '\'' +
                '}';
    }
}
