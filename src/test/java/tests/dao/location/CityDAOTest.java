package tests.dao.location;

import com.opt.saleuk.dao.location.CityDAO;
import com.opt.saleuk.model.location.City;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

/**
 * Created by Arizel on 11.01.2018.
 */
public class CityDAOTest extends AbstractTest {

    private static final Logger LOG = Logger.getLogger(CityDAOTest.class);

    @Autowired
    private CityDAO cityDAO;

    @Test
    public void getAllCityTest() {
        LOG.info(SEPARATOR);
        LOG.info("getAllCityTest was started");

        Iterable<City> cities = cityDAO.findAll();

        LOG.info(cities);

        Assert.assertNotNull(cities);
    }

    @Test
    public void crudCityTest() {
        LOG.info(SEPARATOR);
        LOG.info("crudCityTest was started");

        City createdCity = insertCity();
        City updatedCity = updateCity(createdCity);
        deleteCity(updatedCity);
    }

    private City updateCity(City createdCity) {
        City city = createUpdatedCity(createdCity.getId());

        LOG.info(SEPARATOR);
        LOG.info("Update city: " + createdCity + " to " + city);

        City updatedCity = cityDAO.save(city);

        LOG.info("Updated city: " + updatedCity);

        Assert.assertNotNull(updatedCity);
        //Assert.assertEquals(updatedCity, city);

        City updatedCityFromDB = cityDAO.findOne(city.getId());

        LOG.info("Get updated city from database: " + updatedCityFromDB);

        //Assert.assertEquals(updatedCity, updatedCityFromDB);

        return updatedCityFromDB;
    }

    private City insertCity() {
        City city = createNewCity();
        LOG.info(SEPARATOR);
        LOG.info("Insert city: " + city);

        City insertedCity = cityDAO.save(city);

        LOG.info("Inserted city: " + insertedCity);

        Assert.assertNotNull(insertedCity);
        Assert.assertEquals(insertedCity, city);

        City cityFromDB = cityDAO.findOne(insertedCity.getId());

        LOG.info("Get inserted city from database: " + cityFromDB);

        //Assert.assertEquals(insertedCity, cityFromDB);

        return cityFromDB;
    }

    private void deleteCity(City city) {
        LOG.info(SEPARATOR);
        LOG.info("Get city: " + city);

        cityDAO.delete(city);
        City deletedCity = cityDAO.findOne(city.getId());

        LOG.info("Get deleted city from database: " + deletedCity);

        Assert.assertNull(deletedCity);
    }

    public static City createNewCity() {
        City city = new City();
        city.setName("Odessa");
        city.setRegion(RegionDAOTest.createNewRegion());
        return city;
    }

    public static City createUpdatedCity(Long id) {
        City city = new City();
        city.setId(id);
        city.setName("New York");
        city.setRegion(RegionDAOTest.createNewRegion());
        return city;
    }

}
