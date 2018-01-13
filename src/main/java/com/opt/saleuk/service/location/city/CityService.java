package com.opt.saleuk.service.location.city;

import com.opt.saleuk.model.location.City;

import java.util.List;

/**
 * Created by Arizel on 13.01.2018.
 */
public interface CityService {
    List<City> findAll();
    City findOne(Long id);
    List<City> findByRegionId(Long regionId);
}
