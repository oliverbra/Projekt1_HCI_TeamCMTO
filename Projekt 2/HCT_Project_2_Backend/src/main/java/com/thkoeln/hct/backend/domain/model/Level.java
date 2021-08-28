package com.thkoeln.hct.backend.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "level")



public class Level {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer id;
    private Integer level;
    private String levelName;
    private Integer levelThreshold;


    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "user_id" )
    private User user;
}

