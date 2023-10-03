package com.backend.hrportal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;

    String approyedDate;

    String expirationDate;

    String codePolicy;
    String type;
    String name;

    String url;


    public Document(String title, String description, String approyedDate, String expirationDate, String codePolicy,String type,String name) {
        this.title = title;
        this.description = description;
        this.approyedDate = approyedDate;
        this.expirationDate = expirationDate;
        this.codePolicy = codePolicy;
        this.type=type;
        this.name=name;
        this.url=url;
    }
}
