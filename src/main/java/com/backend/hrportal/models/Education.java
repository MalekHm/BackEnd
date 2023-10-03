package com.backend.hrportal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data

@NoArgsConstructor

public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String diplome;
    String universite;
    String passingYear;
    String degree;
    @JsonIgnore
    @ManyToOne
    User user;

    public Education(String diplome,String universite,String years,String mention){
        this.diplome=diplome;
        this.universite=universite;
        this.passingYear=years;
        this.degree=mention;
    }
}
