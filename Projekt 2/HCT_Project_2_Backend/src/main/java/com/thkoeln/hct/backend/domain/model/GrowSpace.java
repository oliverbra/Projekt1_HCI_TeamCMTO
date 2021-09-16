package com.thkoeln.hct.backend.domain.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "grow_space")
@Data
@JsonIgnoreProperties("reviews")
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
    private String category;
    private String location;
    /*
       Zusammengesetzt aus den 4 ratings aus Review()
     */
    @Column(nullable = true)
    private Double averageRating;
    private boolean highlighted;


    @OneToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "user_id" )
    @JsonBackReference(value="growspace")
    private User user;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private Set<Review> reviews = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Plants> plants = new HashSet<>();

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "files_id" )
    private File file;





}
