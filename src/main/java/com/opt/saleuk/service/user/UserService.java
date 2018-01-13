package com.opt.saleuk.service.user;

import com.opt.saleuk.dto.RegisterFormDTO;
import com.opt.saleuk.model.user.User;

/**
 * Created by Arizel on 06.01.2018.
 */
public interface UserService {
    User findById(Long id);
    User findByEmail(String email);

    User save(User user);
    User registerUser(RegisterFormDTO registerFormDTO);
}
