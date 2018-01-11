package com.opt.saleuk.model.location;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Arizel on 29.12.2017.
 */
@Entity
@Data
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<Region> regions;

}
