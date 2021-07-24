package com.thkoeln.hct.backend.domain.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@NoArgsConstructor
@Table(name = "reviewCriteria")
@Data

public class ReviewCriteria {

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private Integer faktor;


    @OneToMany(cascade  = CascadeType.ALL)
  //  @JoinColumn(name = "reviewId" , nullable = false)
    private Set<Review> review;

    @OneToMany(cascade  = CascadeType.ALL)
  //  @JoinColumn(name = "critId" , nullable = false)
    private Set<Criteria> criteria;
}
