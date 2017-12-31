package tests.dao.location;

import com.opt.saleuk.dao.locationdao.RegionDAO;
import com.opt.saleuk.model.location.Region;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

/**
 * Created by Arizel on 31.12.2017.
 */
public class RegionDAOTest extends AbstractTest {

    private static final Logger LOG = Logger.getLogger(RegionDAOTest.class);

    @Autowired
    private RegionDAO regionDAO;

    @Test
    public void getAllRegionTest() {
        LOG.info(SEPARATOR);
        LOG.info("getAllRegionTest was started");

        Iterable<Region> regions = regionDAO.findAll();

        LOG.info(regions);

        Assert.assertNotNull(regions);
    }

    @Test
    public void crudRegionTest() {
        LOG.info(SEPARATOR);
        LOG.info("crudRegionTest was started");

        Region createdRegion = insertRegion();
        Region updatedRegion = updateRegion(createdRegion);
        deleteRegion(updatedRegion);
    }

    private Region updateRegion(Region createdRegion) {
        Region region = createUpdatedRegion(createdRegion.getId());

        LOG.info(SEPARATOR);
        LOG.info("Update region: " + createdRegion + " to " + region);

        Region updatedRegion = regionDAO.save(region);

        LOG.info("Updated region: " + updatedRegion);

        Assert.assertNotNull(updatedRegion);
        //Assert.assertEquals(updatedRegion, region);

        Region updatedRegionFromDB = regionDAO.findOne(region.getId());

        LOG.info("Get updated region from database: " + updatedRegionFromDB);

        //Assert.assertEquals(updatedRegion, updatedRegionFromDB);

        return updatedRegionFromDB;
    }

    private Region insertRegion() {
        Region region = createNewRegion();
        LOG.info(SEPARATOR);
        LOG.info("Insert region: " + region);

        Region insertedRegion = regionDAO.save(region);

        LOG.info("Inserted region: " + insertedRegion);

        Assert.assertNotNull(insertedRegion);
        Assert.assertEquals(insertedRegion, region);

        Region regionFromDB = regionDAO.findOne(insertedRegion.getId());

        LOG.info("Get inserted region from database: " + regionFromDB);

        //Assert.assertEquals(insertedRegion, regionFromDB);

        return regionFromDB;
    }

    private void deleteRegion(Region region) {
        LOG.info(SEPARATOR);
        LOG.info("Get region: " + region);

        regionDAO.delete(region);
        Region deletedRegion = regionDAO.findOne(region.getId());

        LOG.info("Get deleted region from database: " + deletedRegion);

        Assert.assertNull(deletedRegion);
    }
    public static Region createNewRegion() {
        Region region = new Region();
        region.setName("Odessa");
        region.setLocation(LocationDAOTest.createNewLocation());
        return region;
    }

    public static Region createUpdatedRegion(Long id) {
        Region region = new Region();
        region.setId(id);
        region.setName("New York");
        region.setLocation(LocationDAOTest.createNewLocation());
        return region;
    }
}
