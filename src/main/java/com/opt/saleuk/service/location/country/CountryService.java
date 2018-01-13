package com.opt.saleuk.service.location.country;

import com.opt.saleuk.model.location.Country;

import java.util.List;

/**
 * Created by Arizel on 13.01.2018.
 */
public interface CountryService {
    List<Country> findAll();
    Country findOne(Long id);
}
