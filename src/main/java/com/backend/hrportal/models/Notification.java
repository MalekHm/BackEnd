package com.backend.hrportal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String description;

    boolean vu=false;
    Date notificationDate;
    @OneToOne
    User user;

    public Notification(String description) {
        this.description = description;
        this.notificationDate = new Date(System.currentTimeMillis());
    }
}


