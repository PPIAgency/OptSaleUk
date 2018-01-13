package com.opt.saleuk.service.authentication;

import com.opt.saleuk.dto.AuthFormDTO;
import com.opt.saleuk.dto.RegisterFormDTO;
import com.opt.saleuk.dto.ResponseDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Arizel on 07.01.2018.
 */
public interface AuthenticationService {

    ResponseDTO authorize(AuthFormDTO authFormDTO);
    ResponseDTO authorize(String login, String password);
    ResponseDTO register(RegisterFormDTO registerFormDTO);
    ResponseDTO logout(HttpServletRequest request, HttpServletResponse response);

}
