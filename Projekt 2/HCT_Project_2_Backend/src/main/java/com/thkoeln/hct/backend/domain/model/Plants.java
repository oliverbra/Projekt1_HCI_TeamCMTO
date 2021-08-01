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
    private String commonName;
    @Column(nullable = false)
    private String botanicalName;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String descriptionText;
    @Column(nullable = false)
    private String plantCategory;
    private String growthCharacteristics;
    private String blossomingTime;
    private String blossomColour;
    private String poisonous;
    private String nectarPollen;
    private String nativty;
    private String ornamentalValue;
    private String utilityValue;
    @Column(nullable = false)
    private String light;
    private String soil;
    private String soilMoisture;
    private String phValue;
    private String nutrientRequirements;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String careText;
    @Column(nullable = false)
    private String url;
}

