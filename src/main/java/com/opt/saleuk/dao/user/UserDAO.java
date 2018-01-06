package com.opt.saleuk.dao.user;

import com.opt.saleuk.model.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Arizel on 25.12.2017.
 */
public interface UserDAO extends CrudRepository<User, Long>{

    List<User> findByLastName(String lastName);
    User findByEmail(String email);
    User findByPhone(String phone);

}
