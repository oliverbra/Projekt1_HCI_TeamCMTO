package com.thkoeln.hct.backend.domain.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "review")
@Data

public class Review {
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer reviewId;
    private String text;
    private String comment;



    @ManyToOne(cascade  = CascadeType.ALL)
    @JoinColumn(name = "userId" , nullable = false)
    private User user;

    @ManyToOne(cascade  = CascadeType.ALL)
    @JoinColumn(name = "gsId" , nullable = false)
    private GrowSpace growSpace;

}
