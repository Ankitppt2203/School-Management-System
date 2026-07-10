package com.ankit.school_management.repository;

import com.ankit.school_management.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository
        extends JpaRepository<Result, Long> {

    // Find Results By Student
    List<Result> findByStudentId(
            Long studentId);

    // Find Results By Exam
    List<Result> findByExamId(
            Long examId);

    // Find Results By Grade
    List<Result> findByGrade(
            String grade);
}