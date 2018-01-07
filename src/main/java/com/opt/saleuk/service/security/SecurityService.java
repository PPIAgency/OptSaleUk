package com.opt.saleuk.service.security;

import com.opt.saleuk.model.user.User;

public interface SecurityService {
    boolean cryptUserPassword(User user);
    boolean autoLogin(String username, String password);
}
