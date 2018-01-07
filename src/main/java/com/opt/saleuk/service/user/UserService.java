package com.opt.saleuk.service.user;

import com.opt.saleuk.model.user.User;

/**
 * Created by Arizel on 06.01.2018.
 */
public interface UserService {
    User findUserById(Long id);
    User findUserByEmail(String email);
}
