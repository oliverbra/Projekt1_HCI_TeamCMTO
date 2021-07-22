package com.thkoeln.hct.backend.domain.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "mark")
@Data
public class Mark {

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer markId;

    @OneToMany(cascade  = CascadeType.ALL)
    @JoinColumn(name = "gsId" ,nullable = false)//referencedColumnName = "growSpace"
    private Set<GrowSpace> growSpace;





}
