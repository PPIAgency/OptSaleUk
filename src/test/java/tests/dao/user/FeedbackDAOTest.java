package tests.dao.user;

import com.opt.saleuk.dao.userdao.FeedbackDAO;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

/**
 * Created by Arizel on 30.12.2017.
 */
public class FeedbackDAOTest extends AbstractTest{

    private static final Logger LOG = Logger.getLogger(FeedbackDAOTest.class);

    @Autowired
    private FeedbackDAO feedbackDAO;

    @Test
    public void printHelloWorld() {
        LOG.info("Hello WORLD!");
    }

}
