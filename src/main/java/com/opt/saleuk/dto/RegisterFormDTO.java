package com.opt.saleuk.dto;

import lombok.Data;

/**
 * Created by Arizel on 13.01.2018.
 */
@Data
public class RegisterFormDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordRepeat;
    private String phone;
    private Long countryId;
    private Long regionId;
    private Long cityId;
}
