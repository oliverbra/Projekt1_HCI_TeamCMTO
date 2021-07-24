package com.thkoeln.hct.backend.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "plants_in_gs")
@Data

public class PlantsInGs {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer plantsInGsId;

    @OneToMany(cascade  = CascadeType.ALL)
    @JoinColumn(name = "gsId" ,nullable = false)//referencedColumnName = "growSpace"
    private Set<GrowSpace> growSpace;

    @OneToMany(cascade  = CascadeType.ALL)
    @JoinColumn(name = "plantId" ,nullable = false)//referencedColumnName = "growSpace"
    private Set<Plants> plants;

}
