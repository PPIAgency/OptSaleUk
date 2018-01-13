package com.opt.saleuk.controller;

import com.opt.saleuk.model.location.Region;
import com.opt.saleuk.service.location.region.RegionService;
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
@RequestMapping("/region")
public class RegionController {

    private static final Logger LOG = Logger.getLogger(RegionController.class);

    @Autowired
    private RegionService regionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<Region>> getAllRegions() {
        List<Region> regions = regionService.findAll();

        return new ResponseEntity<>(regions, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Region> getRegionById(@PathVariable("id") Long id) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getRegionById method start with id: " + id);
        }

        Region region = regionService.findOne(id);

        if (LOG.isDebugEnabled()) {
            LOG.debug("get region: " + region);
        }

        return new ResponseEntity<>(region, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/country={countryId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<Region>> getRegionsByCountryId(@PathVariable("countryId") Long countryId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getRegionsByCountryId method start with countryId: " + countryId);
        }

        List<Region> regions = regionService.findAll();

        if (LOG.isDebugEnabled()) {
            LOG.debug("get regions: " + regions);
        }

        return new ResponseEntity<>(regions, HttpStatus.OK);
    }
}
