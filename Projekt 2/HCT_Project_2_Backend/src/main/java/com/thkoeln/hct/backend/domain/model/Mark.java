package com.thkoeln.hct.backend.domain.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mark")
@Data
public class Mark {

    public Mark(){}

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer markId;

    @OneToMany(cascade  = CascadeType.ALL)
    @JoinColumn(name = "gsId" , referencedColumnName = "gsId")
    private Set<GrowSpace> growSpace;



}
