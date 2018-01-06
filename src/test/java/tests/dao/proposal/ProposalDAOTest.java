package tests.dao.proposal;

import com.opt.saleuk.dao.proposal.ProposalDAO;
import com.opt.saleuk.model.proposal.ProductType;
import com.opt.saleuk.model.proposal.Proposal;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;
import tests.dao.user.UserDAOTest;

import java.util.Collections;
import java.util.Date;

/**
 * Created by Arizel on 30.12.2017.
 */
public class ProposalDAOTest extends AbstractTest {

    private static final Logger LOG = Logger.getLogger(ProposalDAOTest.class);

    @Autowired
    private ProposalDAO proposalDAO;

    @Test
    public void getAllProposalTest() {
        LOG.info(SEPARATOR);
        LOG.info("getAllProposalTest was started");

        Iterable<Proposal> proposals = proposalDAO.findAll();

        LOG.info(proposals);

        Assert.assertNotNull(proposals);
    }

    @Test
    public void crudProposalTest() {
        LOG.info(SEPARATOR);
        LOG.info("crudProposalTest was started");

        Proposal createdProposal = insertProposal();
        Proposal updatedProposal = updateProposal(createdProposal);
        deleteProposal(updatedProposal);
    }

    private Proposal updateProposal(Proposal createdProposal) {
        Proposal proposal = createUpdatedProposal(createdProposal.getId());

        LOG.info(SEPARATOR);
        LOG.info("Update proposal: " + createdProposal + " to " + proposal);

        Proposal updatedProposal = proposalDAO.save(proposal);

        LOG.info("Updated proposal: " + updatedProposal);

        Assert.assertNotNull(updatedProposal);
        //Assert.assertEquals(updatedProposal, proposal);

        Proposal updatedProposalFromDB = proposalDAO.findOne(proposal.getId());

        LOG.info("Get updated proposal from database: " + updatedProposalFromDB);

        //Assert.assertEquals(updatedProposal, updatedProposalFromDB);

        return updatedProposalFromDB;
    }

    private Proposal insertProposal() {
        Proposal proposal = createNewProposal();
        LOG.info(SEPARATOR);
        LOG.info("Insert proposal: " + proposal);

        Proposal insertedProposal = proposalDAO.save(proposal);

        LOG.info("Inserted proposal: " + insertedProposal);

        Assert.assertNotNull(insertedProposal);
        Assert.assertEquals(insertedProposal, proposal);

        Proposal proposalFromDB = proposalDAO.findOne(insertedProposal.getId());

        LOG.info("Get inserted proposal from database: " + proposalFromDB);

        //Assert.assertEquals(insertedProposal, proposalFromDB);

        return proposalFromDB;
    }

    private void deleteProposal(Proposal proposal) {
        LOG.info(SEPARATOR);
        LOG.info("Get proposal: " + proposal);

        proposalDAO.delete(proposal);
        Proposal deletedProposal = proposalDAO.findOne(proposal.getId());

        LOG.info("Get deleted proposal from database: " + deletedProposal);

        Assert.assertNull(deletedProposal);
    }

    public static Proposal createNewProposal() {
        Proposal proposal = new Proposal();
        proposal.setName("First Proposal");
        proposal.setAuthor(UserDAOTest.createNewUser());
        proposal.setBuyer(UserDAOTest.createNewUser());
        proposal.setComments(Collections.emptyList());
        proposal.setCost(3427847239L);
        proposal.setCount(4234);
        proposal.setCreateDate(new Date());
        proposal.setEndDate(new Date());
        proposal.setProductType(ProductType.FRUIT);

        return proposal;
    }

    public static Proposal createUpdatedProposal(Long id) {
        Proposal proposal = new Proposal();
        proposal.setId(id);
        proposal.setName("Updated Proposal");
        proposal.setAuthor(UserDAOTest.createNewUser());
        proposal.setBuyer(UserDAOTest.createNewUser());
        proposal.setComments(Collections.emptyList());
        proposal.setCost(12321L);
        proposal.setCount(1);
        proposal.setCreateDate(new Date());
        proposal.setEndDate(new Date());
        proposal.setProductType(ProductType.CEREALS);

        return proposal;
    }

}
