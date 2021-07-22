package com.thkoeln.hct.backend.domain.model;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table (name = "user")
@Data

public class User {

    public User() {
        setUserId(1);
        setEmail("test@test.test");
        setName("TestUser");
        setAge("25");
        setProgress("Blümchen");
        setLevel(null);
    }

    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer userId;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    private String progress;
    @Column(nullable = false)
    private String password;

    @OneToMany(cascade  = CascadeType.ALL)
  //  @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "levelId" , referencedColumnName = "levelId")
    //private Level level;
     private Set<Level> level;

    @OneToMany(cascade  = CascadeType.ALL)
    //  @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "gsId" , referencedColumnName = "gsId")
    //private Level level;
    private Set<GrowSpace> growSpace;

}
