package com.opt.saleuk.model.user;

import com.opt.saleuk.model.location.Region;
import com.opt.saleuk.model.proposal.Comment;
import com.opt.saleuk.model.proposal.Proposal;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Arizel on 25.12.2017.
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "description_of_work")
    private String descriptionOfWork;

    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Feedback> myFeedbackList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Feedback> feedbackAboutMeList;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Comment> myComments;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Proposal> myCreatedProposalList;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
    private List<Proposal> myRespondedProposalList;

}
