package com.thkoeln.hct.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gs_Id", referencedColumnName = "id")
    private GrowSpace growSpace;

    @OneToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "files_id",referencedColumnName = "id")
    private File file;
}

