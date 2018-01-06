package com.opt.saleuk.dao.user;

import com.opt.saleuk.model.user.Feedback;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Arizel on 30.12.2017.
 */
public interface FeedbackDAO extends CrudRepository<Feedback, Long> {
}
