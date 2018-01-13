package com.opt.saleuk.service.validator;

import com.opt.saleuk.dto.RegisterFormDTO;
import com.opt.saleuk.model.user.User;
import com.opt.saleuk.model.user.UserStatus;
import com.opt.saleuk.service.user.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Arizel on 06.01.2018.
 */
@Service
public class AuthenticationValidatorImpl implements AuthenticationValidator {

    private static final Logger LOG = Logger.getLogger(AuthenticationValidatorImpl.class);

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean validateAuthorization(String login, String password) {

        if (StringUtils.isEmpty(login)) {
            return false;
        } else if (StringUtils.isEmpty(password)) {
            return false;
        }

        User user = userServiceImpl.findByEmail(login);

        if (user == null) {
            return false;
        } else if (user.getRole() == null) {
            return false;
        } else if (user.getStatus() != UserStatus.ACTIVE) {
            return false;
        }

        return bCryptPasswordEncoder.matches(password, user.getPassword());
    }

    @Override
    public boolean validateRegistration(RegisterFormDTO registerFormDTO) {
        //TODO Need to write validations for the phone, email, passwords and country, region, city
        return true;
    }

}
