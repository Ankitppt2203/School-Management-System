package com.ankit.school_management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(
            message = "Course name cannot be empty")
    private String name;

    @JsonBackReference("student-course")
    @ManyToMany(
            mappedBy = "courses",
            fetch = FetchType.LAZY)
    private List<Student> students;

    public Course() {
    }

    public Course(
            String name,
            List<Student> students) {

        this.name = name;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(
            String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(
            List<Student> students) {
        this.students = students;
    }
}