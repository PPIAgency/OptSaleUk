package com.opt.saleuk.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opt.saleuk.model.location.City;
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
    @JsonIgnore
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @JsonIgnore
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private UserStatus status;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "description_of_work")
    private String descriptionOfWork;

    @JsonIgnore
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    @JsonIgnore
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "region_id")
    private Region region;

    @JsonIgnore
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Feedback> myFeedbackList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Feedback> feedbackAboutMeList;

    @JsonIgnore
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Comment> myComments;

    @JsonIgnore
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Proposal> myCreatedProposalList;

    @JsonIgnore
    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
    private List<Proposal> myRespondedProposalList;

}
