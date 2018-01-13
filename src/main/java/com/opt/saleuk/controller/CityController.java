package com.opt.saleuk.controller;

import com.opt.saleuk.model.location.City;
import com.opt.saleuk.service.location.city.CityService;
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
@RequestMapping("/city")
public class CityController {

    private static final Logger LOG = Logger.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<City>> getAllCity() {
        List<City> cities = cityService.findAll();

        if (LOG.isDebugEnabled()) {
            LOG.debug("get cities: " + cities);
        }

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @RequestMapping(value = "/{regionId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<City> getCityById(@PathVariable("regionId") Long id) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getCityById method start with regionId: " + id);
        }

        City city = cityService.findOne(id);

        if (LOG.isDebugEnabled()) {
            LOG.debug("get city: " + city);
        }

        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @RequestMapping(value = "/region={regionId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<City>> getAllCityByRegionId(@PathVariable("regionId") Long regionId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getAllCityByRegionId method start with regionId: " + regionId);
        }

        List<City> cities = cityService.findByRegionId(regionId);

        if (LOG.isDebugEnabled()) {
            LOG.debug("get cities: " + cities);
        }

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

}
