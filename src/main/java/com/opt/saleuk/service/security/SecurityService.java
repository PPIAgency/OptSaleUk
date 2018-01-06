package com.opt.saleuk.service.security;

import com.opt.saleuk.model.user.User;

public interface SecurityService {
    boolean cryptUserPass(User user);
    boolean isPasswordMatchEncrypted(String raw, String encoded);
    long getAuthenticatedUserIdByEmail(String email);
    boolean autoLogin(String username, String password);
}
