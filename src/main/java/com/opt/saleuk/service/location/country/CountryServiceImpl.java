package com.opt.saleuk.service.location.country;

import com.opt.saleuk.dao.location.CountryDAO;
import com.opt.saleuk.model.location.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Arizel on 13.01.2018.
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDAO countryDAO;

    @Override
    public List<Country> findAll() {
        return countryDAO.findAll();
    }

    @Override
    public Country findOne(Long id) {
        return countryDAO.findOne(id);
    }
}
