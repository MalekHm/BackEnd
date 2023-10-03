package com.backend.hrportal.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String title;
    String score;
     @JsonIgnore
    @ManyToOne
    User user;
    public Skills(String title,String score){
        this.title=title;
        this.score=score;
    }
}
