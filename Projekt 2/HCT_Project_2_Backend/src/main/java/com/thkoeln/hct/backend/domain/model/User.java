package com.thkoeln.hct.backend.domain.model;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table (name = "user")
@Data

public class User {

    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    @Id
    @NonNull
    private Integer userId;
    @NonNull
    private String email;
    @NonNull
    private String name;
    @NonNull
    private String age;
    @NonNull
    private String progress;
    @NonNull
    private String password;

    @OneToMany(cascade  = CascadeType.ALL)
  //  @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "levelId" , referencedColumnName = "levelId")
    //private Level level;
     private Set<Level> level;
    public User() {
        setUserId(1);
        setEmail("test@test.test");
        setName("TestUser");
        setAge("25");
        setProgress("Blümchen");
        setLevel(null);
    }
}
