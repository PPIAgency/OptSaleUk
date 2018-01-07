package com.opt.saleuk.service.authorization;

/**
 * Created by Arizel on 07.01.2018.
 */
public interface AuthorizationService {

    boolean authorize(String login, String password);

}
