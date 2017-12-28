package com.opt.saleuk.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Arizel on 29.12.2017.
 */
@Data
public class Feedback extends AbstractEntity {

    private User author;
    private User user;
    private String message;
    private Date createDate;

}
