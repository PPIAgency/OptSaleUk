package tests.dao.delivery;

import com.opt.saleuk.dao.deliverydao.DeliveryDAO;
import com.opt.saleuk.model.delivery.Delivery;
import com.opt.saleuk.model.delivery.DeliveryType;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;


/**
 * Created by Arizel on 30.12.2017.
 */
public class DeliveryDAOTest extends AbstractTest {

    private static final Logger LOG = Logger.getLogger(DeliveryDAOTest.class);

    @Autowired
    private DeliveryDAO deliveryDAO;

    @Test
    public void getAllDeliveryTest() {
        LOG.info(SEPARATOR);
        LOG.info("getAllDeliveryTest was started");

        Iterable<Delivery> deliveries = deliveryDAO.findAll();

        LOG.info(deliveries);

        Assert.assertNotNull(deliveries);
    }

    @Test
    public void crudDeliveryTest() {
        LOG.info(SEPARATOR);
        LOG.info("crudDeliveryTest was started");

        Delivery createdDelivery = insertDelivery();
        Delivery updatedDelivery = updateDelivery(createdDelivery);
        deleteDelivery(updatedDelivery);
    }

    private Delivery createNewEntity() {
        Delivery delivery = new Delivery();
        delivery.setName("Fast delivery");
        delivery.setDescription("It is fast delivery");
        delivery.setType(DeliveryType.COURIER);

        return delivery;
    }

    private Delivery createUpdatedDelivery(Long id) {
        Delivery delivery = new Delivery();
        delivery.setId(id);
        delivery.setName("Updated Fast delivery");
        delivery.setDescription("It is updated fast delivery");
        delivery.setType(DeliveryType.PICKUP);

        return delivery;
    }

    private Delivery updateDelivery(Delivery createdDelivery) {
        Delivery delivery = createUpdatedDelivery(createdDelivery.getId());

        LOG.info(SEPARATOR);
        LOG.info("Update delivery: " + createdDelivery + " to " + delivery);

        Delivery updatedDelivery = deliveryDAO.save(delivery);

        LOG.info("Updated delivery: " + updatedDelivery);

        Assert.assertNotNull(updatedDelivery);
        Assert.assertEquals(updatedDelivery, delivery);

        Delivery updatedDeliveryFromDB = deliveryDAO.findOne(delivery.getId());

        LOG.info("Get updated delivery from database: " + updatedDeliveryFromDB);

        Assert.assertEquals(updatedDelivery, updatedDeliveryFromDB);

        return updatedDeliveryFromDB;
    }

    private Delivery insertDelivery() {
        Delivery delivery = createNewEntity();
        LOG.info(SEPARATOR);
        LOG.info("Insert delivery: " + delivery);

        Delivery insertedDelivery = deliveryDAO.save(delivery);

        LOG.info("Inserted delivery: " + insertedDelivery);

        Assert.assertNotNull(insertedDelivery);
        Assert.assertEquals(insertedDelivery, delivery);

        Delivery deliveryFromDB = deliveryDAO.findOne(insertedDelivery.getId());

        LOG.info("Get inserted delivery from database: " + deliveryFromDB);

        Assert.assertEquals(insertedDelivery, deliveryFromDB);

        return deliveryFromDB;
    }

    private void deleteDelivery(Delivery delivery) {
        LOG.info(SEPARATOR);
        LOG.info("Get delivery: " + delivery);

        deliveryDAO.delete(delivery);
        Delivery deletedDelivery = deliveryDAO.findOne(delivery.getId());

        LOG.info("Get deleted delivery from database: " + deletedDelivery);

        Assert.assertNull(deletedDelivery);
    }

}
