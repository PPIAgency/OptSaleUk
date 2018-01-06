package com.opt.saleuk.dao.proposal;

import com.opt.saleuk.model.proposal.Proposal;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Arizel on 30.12.2017.
 */
public interface ProposalDAO extends CrudRepository<Proposal, Long> {
}
