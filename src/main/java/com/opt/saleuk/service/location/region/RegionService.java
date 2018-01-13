package com.opt.saleuk.service.location.region;

import com.opt.saleuk.model.location.Region;

import java.util.List;

/**
 * Created by Arizel on 13.01.2018.
 */
public interface RegionService {
    List<Region> findAll();
    Region findOne(Long id);
    List<Region> findByCountryId(Long countryId);
}
