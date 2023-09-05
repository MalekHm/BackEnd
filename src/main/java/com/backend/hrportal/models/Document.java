package com.backend.hrportal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    String type;
    Date startDate;
    Date endDate;

    String summary;

    String file;

    public Document(String title, String type, Date startDate, Date endDate, String summary,String file) {
        this.title = title;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;
        this.file=file;
    }
}
