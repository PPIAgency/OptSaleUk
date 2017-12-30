package tests;

import com.opt.saleuk.Application;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tests.dao.delivery.DeliveryDAOTest;

/**
 * Created by Arizel on 30.12.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AbstractTest {

    private static final Logger LOG = Logger.getLogger(DeliveryDAOTest.class);
    protected static final String SEPARATOR = "--------------------------------------------------";

    @Test
    public void printHelloWorld() {
        LOG.info("Hello WORLD!");
    }

    protected class Entry<T> {

        private T modifiableEntity;
        private T entity;

        public Entry(T modifiableEntity, T entity) {
            this.modifiableEntity = modifiableEntity;
            this.entity = entity;
        }

        public T getModifiableEntity() {
            return modifiableEntity;
        }

        public T getEntity() {
            return entity;
        }
    }

}
