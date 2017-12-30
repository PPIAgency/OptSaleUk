package com.opt.saleuk.dao.deliverydao;

import com.opt.saleuk.model.delivery.Delivery;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Arizel on 30.12.2017.
 */
public interface DeliveryDAO extends CrudRepository<Delivery, Long> {
}
