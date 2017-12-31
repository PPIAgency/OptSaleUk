package tests.dao.location;

import com.opt.saleuk.dao.locationdao.LocationDAO;
import com.opt.saleuk.model.location.Location;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

import java.util.Collections;

/**
 * Created by Arizel on 31.12.2017.
 */
public class LocationDAOTest extends AbstractTest {

    private static final Logger LOG = Logger.getLogger(LocationDAOTest.class);

    @Autowired
    private LocationDAO locationDAO;

    @Test
    public void getAllLocationTest() {
        LOG.info(SEPARATOR);
        LOG.info("getAllLocationTest was started");

        Iterable<Location> locations = locationDAO.findAll();

        LOG.info(locations);

        Assert.assertNotNull(locations);
    }

    @Test
    public void crudLocationTest() {
        LOG.info(SEPARATOR);
        LOG.info("crudLocationTest was started");

        Location createdLocation = insertLocation();
        Location updatedLocation = updateLocation(createdLocation);
        deleteLocation(updatedLocation);
    }

    private Location updateLocation(Location createdLocation) {
        Location location = createUpdatedLocation(createdLocation.getId());

        LOG.info(SEPARATOR);
        LOG.info("Update location: " + createdLocation + " to " + location);

        Location updatedLocation = locationDAO.save(location);

        LOG.info("Updated location: " + updatedLocation);

        Assert.assertNotNull(updatedLocation);
        //Assert.assertEquals(updatedLocation, location);

        Location updatedLocationFromDB = locationDAO.findOne(location.getId());

        LOG.info("Get updated location from database: " + updatedLocationFromDB);

        //Assert.assertEquals(updatedLocation, updatedLocationFromDB);

        return updatedLocationFromDB;
    }

    private Location insertLocation() {
        Location location = createNewLocation();
        LOG.info(SEPARATOR);
        LOG.info("Insert location: " + location);

        Location insertedLocation = locationDAO.save(location);

        LOG.info("Inserted location: " + insertedLocation);

        Assert.assertNotNull(insertedLocation);
        Assert.assertEquals(insertedLocation, location);

        Location locationFromDB = locationDAO.findOne(insertedLocation.getId());

        LOG.info("Get inserted location from database: " + locationFromDB);

        //Assert.assertEquals(insertedLocation, locationFromDB);

        return locationFromDB;
    }

    private void deleteLocation(Location location) {
        LOG.info(SEPARATOR);
        LOG.info("Get location: " + location);

        locationDAO.delete(location);
        Location deletedLocation = locationDAO.findOne(location.getId());

        LOG.info("Get deleted location from database: " + deletedLocation);

        Assert.assertNull(deletedLocation);
    }

    public static Location createNewLocation() {
        Location location = new Location();
        location.setCode("UK");
        location.setName("Ukraine");
        location.setRegions(Collections.emptyList());

        return location;
    }

    public static Location createUpdatedLocation(Long id) {
        Location location = new Location();
        location.setId(id);
        location.setCode("USA");
        location.setName("USA");

        return location;
    }

}
