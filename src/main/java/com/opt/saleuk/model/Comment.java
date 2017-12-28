package com.opt.saleuk.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Arizel on 29.12.2017.
 */
@Data
public class Comment extends AbstractEntity {
    private User author;
    private Proposal proposal;
    private String text;
    private Date createDate;
}
