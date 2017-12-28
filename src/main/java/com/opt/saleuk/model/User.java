package com.opt.saleuk.model;

import lombok.Data;

import java.util.List;

/**
 * Created by Arizel on 25.12.2017.
 */
//@Entity
@Data
public class User extends AbstractEntity{

    private String name;
    private String phone;
    private String email;
    private String additionalInfo;
    private String descriptionOfWork;
    private List<Feedback> myFeedbackList;
    private List<Feedback> feedbackAboutMeList;
    private List<Proposal> myActiveProposalList;
    private List<Proposal> myLastProposalList;

}
