package com.opt.saleuk.model.proposal;

import com.opt.saleuk.model.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Arizel on 29.12.2017.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Proposal {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "product_type")
    private ProductType productType;

    @Column(name = "count")
    private Integer count;

    @Column(name = "cost")
    private Long cost;

    @OneToMany(mappedBy = "proposal", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "end_date")
    private Date endDate;

    @Override
    public String toString() {
        return "Proposal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productType=" + productType +
                ", count=" + count +
                ", cost=" + cost +
                ", comments=" + comments +
                ", createDate=" + createDate +
                ", endDate=" + endDate +
                '}';
    }
}
