package com.thkoeln.hct.backend.domain.model;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "expert")
@Data

public class Expert {

    public Expert(){}

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer id;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "user_Id")
    private User user;

}
