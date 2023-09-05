package com.backend.hrportal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String comment;
    String  start;
    String end;

    Boolean valide =false;
Date registrationDate;
    @JsonIgnoreProperties("holidays")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    public Permission(String start,String end,String description){

        this.start=start;
        this.end=end;
        this.comment=description;
        this.registrationDate=new Date(System.currentTimeMillis());
    }

}
