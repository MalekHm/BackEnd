package com.backend.hrportal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String condidat;
    String cv;
    @OneToOne
    User employee;

    @OneToOne
    Position position;

    Date registrationDate;

    public Condidat(String condidat){

        this.condidat=condidat;
        this.registrationDate=new Date(System.currentTimeMillis());

    }
}
