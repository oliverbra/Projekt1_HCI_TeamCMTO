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

    /*
    TODO pictures in db? datatype? hosted where?
     */
    private String picture;
    private String category;
    private String location;
    /*
       Zusammengesetzt aus den 4 ratings aus Review()
     */
    @Column(nullable = true)
    private Double averageRating;
    private boolean highlighted;


   @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "user_id" )
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Plants> plants = new HashSet<>();

    /*
    TODO implement plants relationship (manytomany) ??
     */





}
