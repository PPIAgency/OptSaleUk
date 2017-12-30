package com.opt.saleuk.dao.userdao;

import com.opt.saleuk.model.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Arizel on 25.12.2017.
 */
public interface UserDAO extends CrudRepository<User, Long>{

    List<User> findByName(String name);

}
