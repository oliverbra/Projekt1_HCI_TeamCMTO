package com.thkoeln.hct.backend.domain.model;
import com.fasterxml.jackson.annotation.*;


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
    @Column(nullable = false)
    private Integer id;
    private String name;
    private String problems;
    private String goal;
    private Double size;
    private String category;
    private String location;
    @Column(nullable = true)
    private Double averageRating;
    private boolean highlighted;


    @OneToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "user_id" )
    @JsonBackReference(value="growspace")
    private User user;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference(value="review")
    private Set<Review> reviews = new HashSet<>();

    @ManyToMany( cascade = CascadeType.MERGE)
    @JoinTable
    private Set<Plants> plants = new HashSet<>();

//    @ManyToOne(fetch =  FetchType.LAZY)
//    @JoinColumn(name = "files_id" )
//    private File file;

    @OneToMany(mappedBy = "growSpace", cascade = CascadeType.ALL)
    @JsonBackReference(value = "gsFiles")
    private Set<File> files = new HashSet<>();

}
