package com.opt.saleuk.dao.location;

import com.opt.saleuk.model.location.Location;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Arizel on 30.12.2017.
 */
public interface LocationDAO extends CrudRepository<Location, Long> {
}
