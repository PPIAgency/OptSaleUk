package com.opt.saleuk.service.authorization;

import com.opt.saleuk.dto.Response;
import com.opt.saleuk.model.user.User;
import com.opt.saleuk.service.Messages;
import com.opt.saleuk.service.security.SecurityService;
import com.opt.saleuk.service.user.UserService;
import com.opt.saleuk.service.validator.AuthorizationValidator;
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
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private AuthorizationValidator authorizationValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Override
    public Response authorize(String login, String password) {

        Response response = new Response();

        if (!authorizationValidator.validateAuthorization(login, password)) {
            response.setSuccess(false);
            response.setMessage(Messages.AUTHORIZATION_NOT_SUCCESS);
            return response;
        }

        if (securityService.autoLogin(login, password)) {
            response.setSuccess(true);
            response.setMessage(Messages.AUTHORIZATION_SUCCESS);
        } else {
            response.setSuccess(false);
            response.setMessage(Messages.AUTHORIZATION_NOT_SUCCESS);
        }

        return response;
    }

    @Override
    public Response register(String login, String password, String repeatPassword) {

        Response response = new Response();

        if (!authorizationValidator.validateRegistration(login, password, repeatPassword)) {
            response.setSuccess(false);
            response.setMessage(Messages.REGISTRATION_NOT_SUCCESS);
            return response;
        }

        User user = userService.registerUser(login, password);
        if (!securityService.cryptUserPassword(user)) {
            response.setSuccess(false);
            response.setMessage(Messages.CRYPT_PASSWORD_NOT_SUCCESS);
        } else {
            response.setSuccess(true);
            response.setMessage(Messages.REGISTRATION_SUCCESS);
        }

        userService.save(user);

        return response;
    }

    @Override
    public Response logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        Response answer = new Response();
        answer.setSuccess(true);
        answer.setMessage(Messages.LOGOUT_SUCCESS);

        return answer;
    }
}
