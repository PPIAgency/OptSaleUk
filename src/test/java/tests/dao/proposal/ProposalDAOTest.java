package tests.dao.proposal;

import com.opt.saleuk.model.proposal.ProductType;
import com.opt.saleuk.model.proposal.Proposal;
import org.apache.log4j.Logger;
import tests.AbstractTest;
import tests.dao.user.UserDAOTest;

import java.util.Collections;
import java.util.Date;

/**
 * Created by Arizel on 30.12.2017.
 */
public class ProposalDAOTest extends AbstractTest {

    private static final Logger LOG = Logger.getLogger(ProposalDAOTest.class);

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
