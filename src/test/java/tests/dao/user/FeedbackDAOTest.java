package tests.dao.user;

import com.opt.saleuk.dao.user.FeedbackDAO;
import com.opt.saleuk.model.user.Feedback;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

import java.util.Date;

/**
 * Created by Arizel on 30.12.2017.
 */
public class FeedbackDAOTest extends AbstractTest{

    private static final Logger LOG = Logger.getLogger(FeedbackDAOTest.class);

    @Autowired
    private FeedbackDAO feedbackDAO;

    @Test
    public void getAllFeedbackTest() {
        LOG.info(SEPARATOR);
        LOG.info("getAllFeedbackTest was started");

        Iterable<Feedback> feedbacks = feedbackDAO.findAll();

        LOG.info(feedbacks);

        Assert.assertNotNull(feedbacks);
    }

    @Test
    public void runCreateFeedback() {
        feedbackDAO.save(createNewFeedback());
    }

    @Test
    public void crudDeliveryTest() {
        LOG.info(SEPARATOR);
        LOG.info("crudDeliveryTest was started");

        Feedback createdFeedback = insertFeedback();
        Feedback updatedFeedback = updateFeedback(createdFeedback);
        deleteFeedback(updatedFeedback);
    }

    private Feedback updateFeedback(Feedback createdFeedback) {
        Feedback feedback = createUpdatedFeedback(createdFeedback.getId());

        LOG.info(SEPARATOR);
        LOG.info("Update feedback: " + createdFeedback + " to " + feedback);

        Feedback updatedFeedback = feedbackDAO.save(feedback);

        LOG.info("Updated feedback: " + updatedFeedback);

        Assert.assertNotNull(updatedFeedback);
        //Assert.assertEquals(updatedFeedback, feedback);

        Feedback updatedFeedbackFromDB = feedbackDAO.findOne(feedback.getId());

        LOG.info("Get updated feedback from database: " + updatedFeedbackFromDB);

        //Assert.assertEquals(updatedFeedback, updatedFeedbackFromDB);

        return updatedFeedbackFromDB;
    }

    private Feedback insertFeedback() {
        Feedback feedback = createNewFeedback();
        LOG.info(SEPARATOR);
        LOG.info("Insert feedback: " + feedback);

        Feedback insertedFeedback = feedbackDAO.save(feedback);

        LOG.info("Inserted feedback: " + insertedFeedback);

        Assert.assertNotNull(insertedFeedback);
        Assert.assertEquals(insertedFeedback, feedback);

        Feedback feedbackFromDB = feedbackDAO.findOne(insertedFeedback.getId());

        LOG.info("Get inserted feedback from database: " + feedbackFromDB);

        //Assert.assertEquals(insertedFeedback, feedbackFromDB);

        return feedbackFromDB;
    }

    private void deleteFeedback(Feedback feedback) {
        LOG.info(SEPARATOR);
        LOG.info("Get feedback: " + feedback);

        feedbackDAO.delete(feedback);
        Feedback deletedFeedback = feedbackDAO.findOne(feedback.getId());

        LOG.info("Get deleted feedback from database: " + deletedFeedback);

        Assert.assertNull(deletedFeedback);
    }

    public static Feedback createNewFeedback() {
        Feedback feedback = new Feedback();
        feedback.setCreateDate(new Date());
        feedback.setMessage("First message");
        feedback.setAuthor(UserDAOTest.createNewUser());
        feedback.setUser(UserDAOTest.createNewUser());

        return feedback;
    }

    public static Feedback createUpdatedFeedback(Long id) {
        Feedback feedback = new Feedback();
        feedback.setId(id);
        feedback.setCreateDate(new Date());
        feedback.setMessage("Updated message");
        feedback.setAuthor(UserDAOTest.createNewUser());
        feedback.setUser(UserDAOTest.createNewUser());

        return feedback;
    }

}
