package com.thkoeln.hct.backend.domain.model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.swing.*;

@Entity
@Table (name = "nutzer")
@Data

public class Nutzer {
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    @Id
    @NonNull
    private Integer userId;
    @NonNull
    private String Email;
    @NonNull
    private String Name;
    @NonNull
    private String Alte;
    @NonNull
    private String Fortschritt;
    @NonNull
    private Integer level;
    @NonNull
    private JPasswordField passwort;

    public Nutzer() {

    }
}
