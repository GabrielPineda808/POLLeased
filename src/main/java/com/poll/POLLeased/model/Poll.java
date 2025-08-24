package com.poll.POLLeased.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;

    //jpa creates separate table in db that takes the poll id and this options list as columns and data
    //using id as a foreign key pointing ot poll id and do this to have them related without making a new model
    @ElementCollection
    private List<Vote> options = new ArrayList<>();

//    @ElementCollection
//    private List<Vote> votes = new ArrayList<>();

    public Poll() {
    }

    public Poll(String question, List<Vote> options) {
        this.question = question;
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Vote> getOptions() {
        return options;
    }

    public void setOptions(List<Vote> options) {
        this.options = options;
    }
}
