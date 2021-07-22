package com.thkoeln.hct.backend.domain.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "expert")
@Data

public class Expert {

    public Expert(){}

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer expertId;

    @OneToMany(cascade  = CascadeType.ALL)
    @JoinColumn(name = "userId" ,nullable = false )//referencedColumnName = "gsId"
    private Set<User> user;
}
