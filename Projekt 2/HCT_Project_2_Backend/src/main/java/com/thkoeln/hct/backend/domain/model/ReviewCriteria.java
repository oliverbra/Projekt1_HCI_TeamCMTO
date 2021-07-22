package com.thkoeln.hct.backend.domain.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "reviewCriteria")
@Data

public class ReviewCriteria {

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer critId;
    @Column(nullable = false)
    private Integer faktor;
    private String name;
    private String explanation;
    private String scope;

    @ManyToOne(cascade  = CascadeType.ALL)
    @JoinColumn(name = "reviewId" , nullable = false)
    private Review review;
}
