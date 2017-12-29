package com.opt.saleuk.model.user;

import com.opt.saleuk.model.proposal.Proposal;
import com.opt.saleuk.model.proposal.Comment;
import lombok.Data;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Feedback> myFeedbackList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Feedback> feedbackAboutMeList;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Comment> myComments;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Proposal> myCreatedProposalList;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
    private List<Proposal> myRespondedProposalList;

}
