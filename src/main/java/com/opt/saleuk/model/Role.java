package com.opt.saleuk.model;

/**
 * Created by Arizel on 29.12.2017.
 */
public enum Role {

    ADMIN("Admin"),
    PROVIDER("Provider"),
    BUYER("Buyer");

    Role(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }
}
