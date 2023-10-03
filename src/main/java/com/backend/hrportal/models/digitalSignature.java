package com.backend.hrportal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class digitalSignature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String title;

    String file;
    String description;
    Date approvedDate;

    Date expirationDate;

    String codePolicy;

    public digitalSignature(String title,String file,String description,Date approvedDate,Date expirationDate,String codePolicy){

        this.title=title;
        this.file=file;
        this.description=description;
        this.approvedDate=approvedDate;
        this.expirationDate=expirationDate;
        this.codePolicy=codePolicy;
    }
}
