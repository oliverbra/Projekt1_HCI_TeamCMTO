package com.thkoeln.hct.backend.domain.model;


import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.util.Set;

@Entity
@Table(name = "grow_space")
@Data

public class GrowSpace {

    public GrowSpace() {}


    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    //@Column(nullable = false)
    private Integer id;
    //@Column(nullable = false)
    private String name;
    //@Column(nullable = false)
    private String problems;
    //@Column(nullable = false)
    private String goal;
    //@Column(nullable = false)
    private Double size;
    private String picture;
    private String category;
    private String location;
    @Column(nullable = true)
    private Double averageRating;

    //@ManyToOne(cascade  = CascadeType.ALL)
   // @JoinColumn(name = "userId" , referencedColumnName = "userId")
   // private Set<User> user;
   // private  User user;
}
