package com.opt.saleuk.service.user;

import com.opt.saleuk.dao.location.CityDAO;
import com.opt.saleuk.dao.location.RegionDAO;
import com.opt.saleuk.dao.user.UserDAO;
import com.opt.saleuk.dto.RegisterFormDTO;
import com.opt.saleuk.model.user.Role;
import com.opt.saleuk.model.user.User;
import com.opt.saleuk.model.user.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Arizel on 06.01.2018.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RegionDAO regionDAO;

    @Autowired
    private CityDAO cityDAO;

    @Override
    public User findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public User registerUser(RegisterFormDTO registerFormDTO) {
        User user = new User();
        user.setFirstName(registerFormDTO.getFirstName());
        user.setLastName(registerFormDTO.getLastName());
        user.setCreateDate(new Date());
        user.setPassword(registerFormDTO.getPassword());
        user.setEmail(registerFormDTO.getEmail());
        user.setPhone(registerFormDTO.getPhone());
        user.setStatus(UserStatus.ACTIVE);
        user.setRole(Role.VIP_USER);
        user.setRegion(regionDAO.findOne(registerFormDTO.getRegionId()));
        if (registerFormDTO.getCityId() != null) {
            user.setCity(cityDAO.findOne(registerFormDTO.getCityId()));
        }

        return user;
    }

}
