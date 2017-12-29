package com.opt.saleuk.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Arizel on 29.12.2017.
 */
@Entity
@Data
public class Feedback {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "message")
    private String message;

    @Column(name = "create_date")
    private Date createDate;

}
