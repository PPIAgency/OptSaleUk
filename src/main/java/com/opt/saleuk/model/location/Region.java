package com.opt.saleuk.model.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opt.saleuk.model.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Arizel on 29.12.2017.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Region {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnore
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private List<City> cities;

    @JsonIgnore
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                ", countryId='" + country.getId() +
                '}';
    }
}
