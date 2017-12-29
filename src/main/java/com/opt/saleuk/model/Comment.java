package com.opt.saleuk.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Arizel on 29.12.2017.
 */
@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;

    @Column(name = "text")
    private String text;

    @Column(name = "create_date")
    private Date createDate;
}
