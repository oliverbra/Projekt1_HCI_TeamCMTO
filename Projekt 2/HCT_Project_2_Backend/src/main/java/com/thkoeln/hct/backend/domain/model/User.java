package com.thkoeln.hct.backend.domain.model;
import lombok.Data;

import javax.persistence.*;
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
    private String name;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    private String progress;
    @Column(nullable = false)
    private String password;

   // @OneToMany(cascade  = CascadeType.ALL)
  //  @OneToMany(fetch = FetchType.LAZY)
    @ManyToOne(cascade  = CascadeType.ALL)
  //  @JoinColumn(name = "levelId" , referencedColumnName = "levelId")
     private Level level;

    @OneToMany(cascade  = CascadeType.ALL)
   // @JoinColumn(name = "gsId" , referencedColumnName = "gsId")
    private Set<GrowSpace> growSpace;



}
