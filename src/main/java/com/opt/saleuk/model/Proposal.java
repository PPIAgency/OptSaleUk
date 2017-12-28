package com.opt.saleuk.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Arizel on 29.12.2017.
 */
@Data
public class Proposal extends AbstractEntity {

    private String name;
    private String type;
    private int count;
    private long cost;
    private List<Comment> comments;
    private Date createDate;
    private Date endDate;

}
