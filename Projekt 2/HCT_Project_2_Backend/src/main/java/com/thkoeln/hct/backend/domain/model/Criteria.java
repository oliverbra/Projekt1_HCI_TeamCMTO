package com.thkoeln.hct.backend.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "criteria")
@Data

public class Criteria {
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer critId;
    @Column(nullable = false)
    private String name;
    private String explanation;
    private String scale;
    private String scope;
}
