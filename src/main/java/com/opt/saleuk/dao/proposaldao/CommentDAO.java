package com.opt.saleuk.dao.proposaldao;

import com.opt.saleuk.model.proposal.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Arizel on 30.12.2017.
 */
public interface CommentDAO extends CrudRepository<Comment, Long> {
}
