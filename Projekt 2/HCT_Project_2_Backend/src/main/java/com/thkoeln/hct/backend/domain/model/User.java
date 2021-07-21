package com.thkoeln.hct.backend.domain.model;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.swing.*;

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
    private Integer level;
    @NonNull
    private JPasswordField password;

    public User() {
    }
}
