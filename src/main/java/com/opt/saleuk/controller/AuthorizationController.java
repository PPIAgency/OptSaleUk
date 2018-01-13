package com.opt.saleuk.controller;

import com.opt.saleuk.dto.Response;
import com.opt.saleuk.service.authorization.AuthorizationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Arizel on 06.01.2018.
 */
@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    private static final Logger LOG = Logger.getLogger(AuthorizationController.class);

    @Autowired
    AuthorizationService authorizationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Response doLogin(@RequestParam(name = "username") String login, @RequestParam(name = "password") String password){

        return authorizationService.authorize(login, password);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public @ResponseBody Response doLogout(HttpServletRequest request, HttpServletResponse response) {

        return authorizationService.logout(request, response);
    }
    
    @RequestMapping(value = "/registration")
    public @ResponseBody Response doRegistration(@RequestParam(name = "username") String login,
                                         @RequestParam(name = "password") String password,
                                         @RequestParam(name = "repeat_password") String repeatPassword) {

        Response response = authorizationService.register(login, password, repeatPassword);
        authorizationService.authorize(login, password);
        return response;
    }

}
