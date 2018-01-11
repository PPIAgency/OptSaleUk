package com.opt.saleuk.model.user;

/**
 * Created by Arizel on 29.12.2017.
 */
public enum UserStatus {
    ACTIVE("Active"),
    BANNED("Banned"),
    DEACTIVATED("Deactivated");

    UserStatus(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }
}
