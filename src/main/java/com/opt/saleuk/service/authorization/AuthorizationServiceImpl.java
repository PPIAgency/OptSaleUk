package com.opt.saleuk.service.authorization;

import com.opt.saleuk.service.security.SecurityService;
import com.opt.saleuk.service.validator.AuthorizationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Arizel on 06.01.2018.
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private AuthorizationValidator authorizationValidator;

    @Autowired
    private SecurityService securityService;

    @Override
    public boolean authorize(String login, String password) {
        if (!authorizationValidator.validateAuthorization(login, password)) {
            return false;
        }

        return securityService.autoLogin(login, password);
    }
}
