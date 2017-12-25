package com.opt.saleuk.repository;

import com.opt.saleuk.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Arizel on 25.12.2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);

}
