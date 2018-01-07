package com.opt.saleuk.service.validator;

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
public class AuthorizationValidatorImpl implements AuthorizationValidator {

    private static final Logger LOG = Logger.getLogger(AuthorizationValidatorImpl.class);

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

        User user = userServiceImpl.findUserByEmail(login);

        if (user == null) {
            return false;
        } else if (user.getRole() == null) {
            return false;
        } else if (user.getStatus() != UserStatus.ACTIVE) {
            return false;
        }

        String encodedPassword = bCryptPasswordEncoder.encode(password);

        LOG.info(encodedPassword);
        LOG.info(user.getPassword());

        encodedPassword = bCryptPasswordEncoder.encode(password);

        LOG.info(encodedPassword);
        LOG.info(user.getPassword());

        LOG.info(encodedPassword.equals(user.getPassword()));



        return bCryptPasswordEncoder.matches(password, user.getPassword());
       // return (bCryptPasswordEncoder.encode(password)).equals(user.getPassword());
    }

}
