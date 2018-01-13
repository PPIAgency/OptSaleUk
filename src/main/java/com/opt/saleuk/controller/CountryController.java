package com.opt.saleuk.controller;

import com.opt.saleuk.model.location.Country;
import com.opt.saleuk.service.location.country.CountryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Arizel on 13.01.2018.
 */
@RestController
@RequestMapping("/country")
public class CountryController {

    private static final Logger LOG = Logger.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryService.findAll();

        if (LOG.isDebugEnabled()) {
            LOG.debug("get countries: " + countries);
        }

        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Country> getCountryById(@PathVariable("id") Long id) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getCountryById method start with id: " + id);
        }

        Country country = countryService.findOne(id);

        if (LOG.isDebugEnabled()) {
            LOG.debug("get country: " + country);
        }

        return new ResponseEntity<>(country, HttpStatus.OK);
    }
}
