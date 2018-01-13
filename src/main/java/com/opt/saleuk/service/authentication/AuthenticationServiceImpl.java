package com.opt.saleuk.service.authentication;

import com.opt.saleuk.dto.AuthFormDTO;
import com.opt.saleuk.dto.RegisterFormDTO;
import com.opt.saleuk.dto.ResponseDTO;
import com.opt.saleuk.model.user.User;
import com.opt.saleuk.service.Messages;
import com.opt.saleuk.service.security.SecurityService;
import com.opt.saleuk.service.user.UserService;
import com.opt.saleuk.service.validator.AuthenticationValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Arizel on 06.01.2018.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger LOG = Logger.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    private AuthenticationValidator authenticationValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Override
    public ResponseDTO authorize(AuthFormDTO authFormDTO) {

        if (authFormDTO == null) {
            return null;
        }

        return authorize(authFormDTO.getLogin(), authFormDTO.getPassword());
    }

    @Override
    public ResponseDTO authorize(String login, String password) {
        ResponseDTO responseDTO = new ResponseDTO();

        if (!authenticationValidator.validateAuthorization(login, password)) {
            responseDTO.setSuccess(false);
            responseDTO.setMessage(Messages.AUTHORIZATION_NOT_SUCCESS);
            return responseDTO;
        }

        if (securityService.autoLogin(login, password)) {
            responseDTO.setSuccess(true);
            responseDTO.setMessage(Messages.AUTHORIZATION_SUCCESS);
        } else {
            responseDTO.setSuccess(false);
            responseDTO.setMessage(Messages.AUTHORIZATION_NOT_SUCCESS);
        }

        return responseDTO;
    }

    @Override
    public ResponseDTO register(RegisterFormDTO registerFormDTO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("register method was started with registerFormDTO: " + registerFormDTO);
        }

        if (registerFormDTO == null) {
            return new ResponseDTO(false, Messages.EMPTY_REGISTER_FORM);
        }

        ResponseDTO responseDTO = new ResponseDTO();

        if (!authenticationValidator.validateRegistration(registerFormDTO)) {
            return new ResponseDTO(false, Messages.REGISTRATION_NOT_SUCCESS);
        }

        User user = userService.registerUser(registerFormDTO);
        if (!securityService.cryptUserPassword(user)) {
            responseDTO.setSuccess(false);
            responseDTO.setMessage(Messages.CRYPT_PASSWORD_NOT_SUCCESS);
        } else {
            responseDTO.setSuccess(true);
            responseDTO.setMessage(Messages.REGISTRATION_SUCCESS);
        }

        userService.save(user);

        return responseDTO;
    }

    @Override
    public ResponseDTO logout(HttpServletRequest request, HttpServletResponse response) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("logout method was started with request: " + request + "; response: " + response);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            if (LOG.isDebugEnabled()) {
                LOG.debug("auth is not null");
            }

            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        ResponseDTO answer = new ResponseDTO();
        answer.setSuccess(true);
        answer.setMessage(Messages.LOGOUT_SUCCESS);

        return answer;
    }
}
