package com.opt.saleuk.model.location;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Arizel on 29.12.2017.
 */
@Entity
@Data
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private List<Region> regions;

}
