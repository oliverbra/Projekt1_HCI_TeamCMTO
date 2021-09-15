package com.thkoeln.hct.backend.domain.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


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


    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<User> user = new HashSet<>();
}

