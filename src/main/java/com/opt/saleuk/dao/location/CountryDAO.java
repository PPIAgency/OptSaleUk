package com.opt.saleuk.dao.location;

import com.opt.saleuk.model.location.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Arizel on 30.12.2017.
 */
public interface CountryDAO extends CrudRepository<Country, Long> {
}
