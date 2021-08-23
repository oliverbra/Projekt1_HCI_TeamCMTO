package com.thkoeln.hct.backend.domain.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    private Date date;
    private Integer localCriteria;
    private Integer shelterCriteria;
    private Integer naturalCriteria;
    private Integer dangerCriteria;


    @ManyToOne(cascade  = CascadeType.ALL)
 //   @JoinColumn(name = "userId" , nullable = false)
    private User user;

    @ManyToOne(cascade  = CascadeType.ALL)
//    @JoinColumn(name = "gsId" , nullable = false)
    private GrowSpace growSpace;

}
