package com.opt.saleuk.service.user;

import com.opt.saleuk.dao.user.UserDAO;
import com.opt.saleuk.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Arizel on 06.01.2018.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findUserById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }

}
