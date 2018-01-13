package com.opt.saleuk.service.location.region;

import com.opt.saleuk.dao.location.RegionDAO;
import com.opt.saleuk.model.location.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Arizel on 13.01.2018.
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionDAO regionDAO;

    @Override
    public List<Region> findAll() {
        return regionDAO.findAll();
    }

    @Override
    public Region findOne(Long id) {
        return regionDAO.findOne(id);
    }

    @Override
    public List<Region> findByCountryId(Long countryId) {
        return regionDAO.findByCountryId(countryId);
    }
}
