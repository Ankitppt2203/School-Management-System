package com.ankit.school_management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(
            value = 1,
            message = "Age must be greater than 0")
    private int age;

    @JsonBackReference("department-student")
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @JsonManagedReference("student-attendance")
    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Attendance> attendanceRecords;

    @JsonManagedReference("student-course")
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_course",
            joinColumns =
            @JoinColumn(name = "student_id"),
            inverseJoinColumns =
            @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    @JsonManagedReference("student-result")
    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Result> results;

    public Student() {
    }

    public Student(
            String name,
            int age,
            Department department,
            List<Attendance> attendanceRecords,
            List<Course> courses,
            List<Result> results) {

        this.name = name;
        this.age = age;
        this.department = department;
        this.attendanceRecords = attendanceRecords;
        this.courses = courses;
        this.results = results;
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

    public int getAge() {
        return age;
    }

    public void setAge(
            int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(
            Department department) {
        this.department = department;
    }

    public List<Attendance> getAttendanceRecords() {
        return attendanceRecords;
    }

    public void setAttendanceRecords(
            List<Attendance> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(
            List<Course> courses) {
        this.courses = courses;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(
            List<Result> results) {
        this.results = results;
    }
}