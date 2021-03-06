package com.opt.saleuk.dao.location;

import com.opt.saleuk.model.location.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Arizel on 11.01.2018.
 */
public interface CityDAO extends CrudRepository<City, Long> {
    List<City> findAll();
    List<City> findByRegionId(Long regionId);
}
