package tests.dao.proposal;

import com.opt.saleuk.dao.proposaldao.CommentDAO;
import com.opt.saleuk.model.proposal.Comment;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;
import tests.dao.user.UserDAOTest;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Arizel on 30.12.2017.
 */
public class CommentDAOTest extends AbstractTest {

    private static final Logger LOG = Logger.getLogger(CommentDAOTest.class);

    @Autowired
    private CommentDAO commentDAO;

    @Test
    public void getAllCommentsTest() {
        LOG.info(SEPARATOR);
        LOG.info("getAllCommentsTest was started");

        Iterable<Comment> comments = commentDAO.findAll();

        LOG.info(comments);

        Assert.assertNotNull(comments);
    }

    @Test
    public void crudCommentTest() {
        LOG.info(SEPARATOR);
        LOG.info("crudCommentTest was started");

        Comment createdComment = insertComment();
        Comment updatedComment = updateComment(createdComment);
        deleteComment(updatedComment);
    }

    private Comment updateComment(Comment createdComment) {
        Comment comment = createUpdatedComment(createdComment.getId());

        LOG.info(SEPARATOR);
        LOG.info("Update comment: " + createdComment + " to " + comment);

        Comment updatedComment = commentDAO.save(comment);

        LOG.info("Updated comment: " + updatedComment);

        Assert.assertNotNull(updatedComment);
        //Assert.assertEquals(updatedComment, comment);

        Comment updatedCommentFromDB = commentDAO.findOne(comment.getId());

        LOG.info("Get updated comment from database: " + updatedCommentFromDB);

        //Assert.assertEquals(updatedComment, updatedCommentFromDB);

        return updatedCommentFromDB;
    }

    private Comment insertComment() {
        Comment comment = createNewComment();

        LOG.info(SEPARATOR);
        LOG.info("Insert comment: " + comment);

        Comment insertedComment = commentDAO.save(comment);

        LOG.info("Inserted comment: " + insertedComment);

        Assert.assertNotNull(insertedComment);
        Assert.assertEquals(insertedComment, comment);

        Comment commentFromDB = commentDAO.findOne(insertedComment.getId());

        LOG.info("Get inserted comment from database: " + commentFromDB);

        Assert.assertEquals(DateUtils.truncate(insertedComment.getCreateDate(), Calendar.MINUTE),
                DateUtils.truncate(commentFromDB.getCreateDate(),Calendar.MINUTE));

        //Assert.assertSame(insertedComment, commentFromDB);

        return commentFromDB;
    }

    private void deleteComment(Comment comment) {
        LOG.info(SEPARATOR);
        LOG.info("Get comment: " + comment);

        commentDAO.delete(comment);
        Comment deletedComment = commentDAO.findOne(comment.getId());

        LOG.info("Get deleted comment from database: " + deletedComment);

        Assert.assertNull(deletedComment);
    }

    public static Comment createNewComment() {
        Comment comment = new Comment();
        comment.setCreateDate(new Date());
        comment.setText("First text");
        comment.setAuthor(UserDAOTest.createNewUser());
        comment.setProposal(ProposalDAOTest.createNewProposal());

        return comment;
    }

    public static Comment createUpdatedComment(Long id) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setCreateDate(new Date());
        comment.setText("Updated text");
        comment.setAuthor(UserDAOTest.createNewUser());
        comment.setProposal(ProposalDAOTest.createNewProposal());

        return comment;
    }

}
