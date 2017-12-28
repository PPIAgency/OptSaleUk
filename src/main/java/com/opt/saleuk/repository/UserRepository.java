package com.opt.saleuk.repository;

import com.opt.saleuk.model.User;

import java.util.List;

/**
 * Created by Arizel on 25.12.2017.
 */
public interface UserRepository {

    List<User> findByName(String name);

}
