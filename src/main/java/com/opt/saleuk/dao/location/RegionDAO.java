package com.opt.saleuk.dao.location;

import com.opt.saleuk.model.location.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Arizel on 30.12.2017.
 */
public interface RegionDAO extends CrudRepository<Region, Long> {
    List<Region> findAll();
    List<Region> findByCountryId(Long countryId);
}
