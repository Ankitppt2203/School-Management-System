package com.ankit.school_management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(
            value = 0,
            message = "Marks cannot be negative")
    @Max(
            value = 100,
            message = "Marks cannot be greater than 100")
    private int marks;

    @NotBlank(
            message = "Grade cannot be empty")
    private String grade;

    @JsonBackReference("student-result")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @JsonBackReference("exam-result")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    private Exam exam;

    public Result() {
    }

    public Result(
            int marks,
            String grade,
            Student student,
            Exam exam) {

        this.marks = marks;
        this.grade = grade;
        this.student = student;
        this.exam = exam;
    }

    public Long getId() {
        return id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(
            int marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(
            String grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(
            Student student) {
        this.student = student;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(
            Exam exam) {
        this.exam = exam;
    }
}