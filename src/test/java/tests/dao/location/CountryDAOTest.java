package tests.dao.location;

import com.opt.saleuk.dao.location.CountryDAO;
import com.opt.saleuk.model.location.Country;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

import java.util.Collections;

/**
 * Created by Arizel on 31.12.2017.
 */
public class CountryDAOTest extends AbstractTest {

    private static final Logger LOG = Logger.getLogger(CountryDAOTest.class);

    @Autowired
    private CountryDAO countryDAO;

    @Test
    public void getAllCountryTest() {
        LOG.info(SEPARATOR);
        LOG.info("getAllCountryTest was started");

        Iterable<Country> locations = countryDAO.findAll();

        LOG.info(locations);

        Assert.assertNotNull(locations);
    }

    @Test
    public void crudCountryTest() {
        LOG.info(SEPARATOR);
        LOG.info("crudCountryTest was started");

        Country createdCountry = insertCountry();
        Country updatedCountry = updateCountry(createdCountry);
        deleteCountry(updatedCountry);
    }

    private Country updateCountry(Country createdCountry) {
        Country country = createUpdatedCountry(createdCountry.getId());

        LOG.info(SEPARATOR);
        LOG.info("Update location: " + createdCountry + " to " + country);

        Country updatedCountry = countryDAO.save(country);

        LOG.info("Updated location: " + updatedCountry);

        Assert.assertNotNull(updatedCountry);
        //Assert.assertEquals(updatedLocation, location);

        Country updatedCountryFromDB = countryDAO.findOne(country.getId());

        LOG.info("Get updated location from database: " + updatedCountryFromDB);

        //Assert.assertEquals(updatedLocation, updatedLocationFromDB);

        return updatedCountryFromDB;
    }

    private Country insertCountry() {
        Country country = createNewCountry();
        LOG.info(SEPARATOR);
        LOG.info("Insert location: " + country);

        Country insertedCountry = countryDAO.save(country);

        LOG.info("Inserted location: " + insertedCountry);

        Assert.assertNotNull(insertedCountry);
        Assert.assertEquals(insertedCountry, country);

        Country countryFromDB = countryDAO.findOne(insertedCountry.getId());

        LOG.info("Get inserted location from database: " + countryFromDB);

        //Assert.assertEquals(insertedLocation, locationFromDB);

        return countryFromDB;
    }

    private void deleteCountry(Country country) {
        LOG.info(SEPARATOR);
        LOG.info("Get location: " + country);

        countryDAO.delete(country);
        Country deletedCountry = countryDAO.findOne(country.getId());

        LOG.info("Get deleted location from database: " + deletedCountry);

        Assert.assertNull(deletedCountry);
    }

    public static Country createNewCountry() {
        Country country = new Country();
        country.setName("Ukraine");
        country.setRegions(Collections.emptyList());

        return country;
    }

    public static Country createUpdatedCountry(Long id) {
        Country country = new Country();
        country.setId(id);
        country.setName("USA");

        return country;
    }

}
