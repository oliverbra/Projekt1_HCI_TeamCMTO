package com.thkoeln.hct.backend.domain.model;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "review")
@Data

public class Review {
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer id;
    private String comment;
    private String date;
    private double localCriteria;
    private double shelterCriteria;
    private double naturalCriteria;
    private double dangerCriteria;
    private double rating;
    private boolean open;


    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "user_id" )
    private User user;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "gs_Id")
    private GrowSpace growSpace;
}
