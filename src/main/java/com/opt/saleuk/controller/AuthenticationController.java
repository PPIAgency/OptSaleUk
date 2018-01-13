package com.opt.saleuk.controller;

import com.opt.saleuk.dto.AuthFormDTO;
import com.opt.saleuk.dto.RegisterFormDTO;
import com.opt.saleuk.dto.ResponseDTO;
import com.opt.saleuk.service.authentication.AuthenticationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Arizel on 06.01.2018.
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private static final Logger LOG = Logger.getLogger(AuthenticationController.class);

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody
    ResponseDTO doLogin(@RequestBody AuthFormDTO authFormDTO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("doLogin method was started with authFormDTO: " + authFormDTO);
        }

        return authenticationService.authorize(authFormDTO);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody
    ResponseDTO doLogout(HttpServletRequest request, HttpServletResponse response) {

        return authenticationService.logout(request, response);
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody
    ResponseDTO doRegistration(@RequestBody RegisterFormDTO registerFormDTO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("doRegistration method was started with registerFormDTO: " + registerFormDTO);
        }

        ResponseDTO responseDTO = authenticationService.register(registerFormDTO);
        if (responseDTO.isSuccess()) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Registration completed successfully");
            }

            authenticationService.authorize(registerFormDTO.getEmail(), registerFormDTO.getPassword());
        }

        return responseDTO;
    }

}
