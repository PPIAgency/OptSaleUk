package com.opt.saleuk.model.location;

import com.opt.saleuk.model.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Arizel on 11.01.2018.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class City {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", regionId=" + region.getId() +
                '}';
    }
}
