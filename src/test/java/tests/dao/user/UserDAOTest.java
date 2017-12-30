package tests.dao.user;

import com.opt.saleuk.model.user.Role;
import com.opt.saleuk.model.user.User;
import com.opt.saleuk.model.user.UserStatus;
import org.apache.log4j.Logger;

import java.util.Collections;

/**
 * Created by Arizel on 30.12.2017.
 */
public class UserDAOTest {

    private static final Logger LOG = Logger.getLogger(UserDAOTest.class);

    public static User createNewUser() {
        User user = new User();
        user.setName("First User");
        user.setPassword("security_password123");
        user.setDescriptionOfWork("I am a provider");
        user.setAdditionalInfo("Fruits");
        user.setEmail("provider@mail.com");
        user.setFeedbackAboutMeList(Collections.emptyList());
        user.setMyComments(Collections.emptyList());
        user.setMyCreatedProposalList(Collections.emptyList());
        user.setMyFeedbackList(Collections.emptyList());
        user.setMyRespondedProposalList(Collections.emptyList());
        user.setPhone("+380638509108");
        user.setStatus(UserStatus.ACTIVE);
        user.setRole(Role.VIP_USER);

        return user;
    }

    public static User createUpdatedUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("Updated User");
        user.setPassword("updated_security_password123");
        user.setDescriptionOfWork("I was updated and now I am a buyer");
        user.setAdditionalInfo("Vegetables");
        user.setEmail("buyer@mail.com");
        user.setFeedbackAboutMeList(Collections.emptyList());
        user.setMyComments(Collections.emptyList());
        user.setMyCreatedProposalList(Collections.emptyList());
        user.setMyFeedbackList(Collections.emptyList());
        user.setMyRespondedProposalList(Collections.emptyList());
        user.setPhone("+38000000000");
        user.setStatus(UserStatus.ACTIVE);
        user.setRole(Role.VIP_USER);

        return user;
    }

}
