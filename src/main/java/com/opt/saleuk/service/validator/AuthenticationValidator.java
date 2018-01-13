package com.opt.saleuk.service.validator;

import com.opt.saleuk.dto.RegisterFormDTO;

/**
 * Created by Arizel on 06.01.2018.
 */
public interface AuthenticationValidator {
    boolean validateAuthorization(String login, String password);
    boolean validateRegistration(RegisterFormDTO registerFormDTO);
}
