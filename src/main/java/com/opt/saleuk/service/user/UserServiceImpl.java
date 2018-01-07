package com.opt.saleuk.service.user;

import com.opt.saleuk.dao.user.UserDAO;
import com.opt.saleuk.model.location.Location;
import com.opt.saleuk.model.location.Region;
import com.opt.saleuk.model.user.Role;
import com.opt.saleuk.model.user.User;
import com.opt.saleuk.model.user.UserStatus;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

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

    @Override
    public User saveUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public User createUser(String login, String password) {
        Location location = new Location();
        location.setCode("UK");
        location.setName("Ukraine");
        location.setRegions(Collections.emptyList());

        Region region = new Region();
        region.setName("Odessa");
        region.setLocation(location);
        region.setUsers(Collections.emptyList());

        User user = new User();
        user.setFirstName("First User");
        user.setLastName("First User");
        user.setCreateDate(new Date());
        user.setPassword(password);
        user.setDescriptionOfWork("I am a provider");
        user.setAdditionalInfo("Fruits");
        user.setEmail(login);
        user.setFeedbackAboutMeList(Collections.emptyList());
        user.setMyComments(Collections.emptyList());
        user.setMyCreatedProposalList(Collections.emptyList());
        user.setMyFeedbackList(Collections.emptyList());
        user.setMyRespondedProposalList(Collections.emptyList());
        user.setPhone("+380638509108" + RandomUtils.nextLong());
        user.setStatus(UserStatus.ACTIVE);
        user.setRole(Role.VIP_USER);
        user.setRegion(region);

        return user;
    }

}
