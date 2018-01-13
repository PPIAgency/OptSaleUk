package com.opt.saleuk.service.location.city;

import com.opt.saleuk.dao.location.CityDAO;
import com.opt.saleuk.model.location.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Arizel on 13.01.2018.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;

    @Override
    public List<City> findAll() {
        return cityDAO.findAll();
    }

    @Override
    public City findOne(Long id) {
        return cityDAO.findOne(id);
    }

    @Override
    public List<City> findByRegionId(Long regionId) {
        return cityDAO.findByRegionId(regionId);
    }
}
