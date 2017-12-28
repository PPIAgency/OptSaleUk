package com.opt.saleuk.model;

import lombok.Data;

/**
 * Created by Arizel on 29.12.2017.
 */
@Data
public class Delivery extends AbstractEntity {

    private String name;
    private String type;
    private String description;

}
