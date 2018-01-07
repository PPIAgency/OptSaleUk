package com.opt.saleuk.service.validator;

/**
 * Created by Arizel on 06.01.2018.
 */
public interface AuthorizationValidator {
    boolean validateAuthorization(String login, String password);
    boolean validateRegistration(String login, String password, String repeatPassword);
}
