package com.opt.saleuk.dao.locationdao;

import com.opt.saleuk.model.location.Region;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Arizel on 30.12.2017.
 */
public interface RegionDAO extends CrudRepository<Region, Long> {
}
