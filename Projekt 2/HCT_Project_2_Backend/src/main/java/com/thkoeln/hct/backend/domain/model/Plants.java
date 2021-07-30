package com.thkoeln.hct.backend.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "plants")

public class Plants {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String common_name;
    @Column(nullable = false)
    private String botanicalName;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String description_text;
    @Column(nullable = false)
    private String plant_category;
    private String growth_characteristics;
    private String blossoming_time;
    private String blossom_colour;
    private String poisonous;
    private String nectar_pollen;
    private String _native;
    private String ornamental_value;
    private String utility_value;
    @Column(nullable = false)
    private String light;
    private String soil;
    private String soil_moisture;
    private String pH_value;
    private String nutrient_requirements;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String care_text;
    @Column(nullable = false)
    private String url;
}

