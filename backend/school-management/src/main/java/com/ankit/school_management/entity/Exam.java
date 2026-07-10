package com.ankit.school_management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Subject cannot be empty")
    private String subject;

    @Min(
            value = 1,
            message = "Max marks must be greater than 0")
    private int maxMarks;

    @JsonManagedReference("exam-result")
    @OneToMany(
            mappedBy = "exam",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Result> results;

    public Exam() {
    }

    public Exam(
            String subject,
            int maxMarks,
            List<Result> results) {

        this.subject = subject;
        this.maxMarks = maxMarks;
        this.results = results;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(
            String subject) {
        this.subject = subject;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(
            int maxMarks) {
        this.maxMarks = maxMarks;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(
            List<Result> results) {
        this.results = results;
    }
}