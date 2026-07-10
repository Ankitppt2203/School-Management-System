package com.ankit.school_management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Department name cannot be empty")
    private String name;

    @JsonManagedReference("department-student")
    @OneToMany(
            mappedBy = "department",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Student> students;

    @JsonManagedReference("department-teacher")
    @OneToMany(
            mappedBy = "department",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Teacher> teachers;

    public Department() {
    }

    public Department(
            Long id,
            String name,
            List<Student> students,
            List<Teacher> teachers) {

        this.id = id;
        this.name = name;
        this.students = students;
        this.teachers = teachers;
    }

    public Long getId() {
        return id;
    }

    public void setId(
            Long id) {
        this.id = id;
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

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(
            List<Teacher> teachers) {
        this.teachers = teachers;
    }
}