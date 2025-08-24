package com.poll.POLLeased.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;

    //jpa creates separate table in db that takes the poll id and this options list as columns and data
    //using id as a foreign key pointing ot poll id and do this to have them related without making a new model
    @ElementCollection
    private List<String> options = new ArrayList<>();

    @ElementCollection
    private List<String> votes = new ArrayList<>();

    public Poll() {
    }

    public Poll(String question, List<String> options, List<String> votes) {
        this.question = question;
        this.options = options;
        this.votes = votes;
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

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<String> getVotes() {
        return votes;
    }

    public void setVotes(List<String> votes) {
        this.votes = votes;
    }
}
