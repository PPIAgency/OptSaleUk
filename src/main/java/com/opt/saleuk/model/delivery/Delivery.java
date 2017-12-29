package com.opt.saleuk.model.delivery;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Arizel on 29.12.2017.
 */
@Entity
@Data
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    private DeliveryType type;

    @Column(name = "description")
    private String description;

}
