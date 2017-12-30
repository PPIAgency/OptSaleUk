package com.opt.saleuk.model.user;

/**
 * Created by Arizel on 29.12.2017.
 */
public enum Role {

    ADMIN("Admin"),
    SUPER_ADMIN("Super Admin"),
    USER("User"),
    VIP_USER("VIP User");

    Role(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }
}
