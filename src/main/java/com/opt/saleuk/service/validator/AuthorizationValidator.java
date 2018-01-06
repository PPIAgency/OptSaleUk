package com.opt.saleuk.service.validator;

import com.opt.saleuk.dto.AuthForm;
import org.springframework.stereotype.Service;

/**
 * Created by Arizel on 06.01.2018.
 */
@Service
public class AuthorizationValidator {

    public boolean validateLogin(AuthForm form) {
        return true;
    }

}
