package com.thkoeln.hct.backend.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "mensch")
@Data
public class Mensch{

    @Id
    //
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    //
    //@GeneratedValue(generator = "UUID")
    //@GenericGenerator(
     //       name = "UUID",
     //       strategy = "org.hibernate.id.UUIDGenerator")
    //@Column(updatable = false, nullable = false)
    //private UUID id;


    private String geschlecht;

    @NonNull
    private Integer PersonAlter;

    @NonNull
    private Double groesse;

    @NonNull
    private Date geburtstag;
    //private Long id;


    public Mensch(String geschlecht,Integer PersonAlter,Double groesse, Date geburtstag){
        this.PersonAlter = PersonAlter;
        this.geburtstag = geburtstag;
        this.geschlecht = geschlecht;
        this.groesse = groesse;
    }

    public  Mensch(){
    }
}
