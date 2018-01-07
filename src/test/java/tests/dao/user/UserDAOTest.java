package tests.dao.user;

import com.opt.saleuk.dao.user.UserDAO;
import com.opt.saleuk.model.user.Role;
import com.opt.saleuk.model.user.User;
import com.opt.saleuk.model.user.UserStatus;
import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tests.AbstractTest;
import tests.dao.location.RegionDAOTest;

import java.util.Collections;
import java.util.Date;

/**
 * Created by Arizel on 30.12.2017.
 */
public class UserDAOTest extends AbstractTest {

    private static final Logger LOG = Logger.getLogger(UserDAOTest.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void getAllUserTest() {
        LOG.info(SEPARATOR);
        LOG.info("getAllUserTest was started");

        Iterable<User> users = userDAO.findAll();

        LOG.info(users);

        Assert.assertNotNull(users);
    }

    @Test
    public void crudUserTest() {
        LOG.info(SEPARATOR);
        LOG.info("crudUserTest was started");

        User createdUser = insertUser();
        User updatedUser = updateUser(createdUser);
        deleteUser(updatedUser);
    }

    @Test
    public void createUserTest() {
        User userFromDB = userDAO.findByEmail("admin");
        if (userFromDB != null) {
            return;
        }

        User user = new User();
        user.setFirstName("First User");
        user.setLastName("First User");
        user.setCreateDate(new Date());
        user.setPassword(bCryptPasswordEncoder.encode("admin"));
        user.setDescriptionOfWork("I am a provider");
        user.setAdditionalInfo("Fruits");
        user.setEmail("admin");
        //user.setEmail("rovider@mail.com" + RandomUtils.nextLong());
        user.setFeedbackAboutMeList(Collections.emptyList());
        user.setMyComments(Collections.emptyList());
        user.setMyCreatedProposalList(Collections.emptyList());
        user.setMyFeedbackList(Collections.emptyList());
        user.setMyRespondedProposalList(Collections.emptyList());
        user.setPhone("+380638509108" + RandomUtils.nextLong());
        user.setStatus(UserStatus.ACTIVE);
        user.setRole(Role.ADMIN);
        user.setRegion(RegionDAOTest.createNewRegion());

        userDAO.save(user);
    }

    private User updateUser(User createdUser) {
        User user = createUpdatedUser(createdUser.getId());

        LOG.info(SEPARATOR);
        LOG.info("Update user: " + createdUser + " to " + user);

        User updatedUser = userDAO.save(user);

        LOG.info("Updated user: " + updatedUser);

        Assert.assertNotNull(updatedUser);
        //Assert.assertEquals(updatedUser, user);

        User updatedUserFromDB = userDAO.findOne(user.getId());

        LOG.info("Get updated user from database: " + updatedUserFromDB);

        //Assert.assertEquals(updatedUser, updatedUserFromDB);

        return updatedUserFromDB;
    }

    private User insertUser() {
        User user = createNewUser();
        LOG.info(SEPARATOR);
        LOG.info("Insert user: " + user);

        User insertedUser = userDAO.save(user);

        LOG.info("Inserted user: " + insertedUser);

        Assert.assertNotNull(insertedUser);
        Assert.assertEquals(insertedUser, user);

        User userFromDB = userDAO.findOne(insertedUser.getId());

        LOG.info("Get inserted user from database: " + userFromDB);

        //Assert.assertEquals(insertedUser, userFromDB);

        return userFromDB;
    }

    private void deleteUser(User user) {
        LOG.info(SEPARATOR);
        LOG.info("Get user: " + user);

        userDAO.delete(user);
        User deletedUser = userDAO.findOne(user.getId());

        LOG.info("Get deleted user from database: " + deletedUser);

        Assert.assertNull(deletedUser);
    }

    public static User createNewUser() {
        User user = new User();
        user.setFirstName("First User");
        user.setLastName("First User");
        user.setCreateDate(new Date());
        user.setPassword("security_password123");
        user.setDescriptionOfWork("I am a provider");
        user.setAdditionalInfo("Fruits");
        user.setEmail("rovider@mail.com" + RandomUtils.nextLong());
        user.setFeedbackAboutMeList(Collections.emptyList());
        user.setMyComments(Collections.emptyList());
        user.setMyCreatedProposalList(Collections.emptyList());
        user.setMyFeedbackList(Collections.emptyList());
        user.setMyRespondedProposalList(Collections.emptyList());
        user.setPhone("+380638509108" + RandomUtils.nextLong());
        user.setStatus(UserStatus.ACTIVE);
        user.setRole(Role.VIP_USER);
        user.setRegion(RegionDAOTest.createNewRegion());

        return user;
    }

    public static User createUpdatedUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setFirstName("Updated User");
        user.setLastName("Updated User");
        user.setCreateDate(new Date());
        user.setPassword("updated_security_password123" + RandomUtils.nextLong());
        user.setDescriptionOfWork("I was updated and now I am a buyer");
        user.setAdditionalInfo("Vegetables");
        user.setEmail("buyer@mail.com" + RandomUtils.nextLong());
        user.setFeedbackAboutMeList(Collections.emptyList());
        user.setMyComments(Collections.emptyList());
        user.setMyCreatedProposalList(Collections.emptyList());
        user.setMyFeedbackList(Collections.emptyList());
        user.setMyRespondedProposalList(Collections.emptyList());
        user.setPhone("+38000000000" + RandomUtils.nextLong());
        user.setStatus(UserStatus.ACTIVE);
        user.setRole(Role.VIP_USER);
        user.setRegion(RegionDAOTest.createNewRegion());

        return user;
    }

}
