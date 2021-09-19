package com.thkoeln.hct.backend.domain.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table (name = "files")
@Data

public class File {

    public File() {
    }

    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer id;
    private String fileName;
    private String name;

    private String fileType;
    @Lob
    private byte[] data;



    public File(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }


//    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private Set<GrowSpace> growSpaces = new HashSet<>();

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "growSpace_id" )
    private GrowSpace growSpace;


    @OneToOne(mappedBy = "file", cascade = CascadeType.ALL)
    private Plants plants;

    @OneToOne(mappedBy = "file", cascade = CascadeType.ALL)
    private User user;




}