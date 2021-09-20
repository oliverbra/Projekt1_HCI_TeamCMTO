package com.thkoeln.hct.backend.domain.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table (name = "user")
@Data
public class User {

    public User() {
    }

    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    private Integer growpoints;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference(value = "reviews")
    private Set<Review> reviews = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value="growspace")
    private GrowSpace growSpace;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "level_id")
    private Level level;


    @OneToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "files_id",referencedColumnName = "id")
    private File file;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference(value="files")
//    private File file;

}
