package com.opt.saleuk.service.authorization;

import com.opt.saleuk.dto.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Arizel on 07.01.2018.
 */
public interface AuthorizationService {

    Response authorize(String login, String password);
    Response register(String login, String password, String repeatPassword);
    Response logout(HttpServletRequest request, HttpServletResponse response);

}
