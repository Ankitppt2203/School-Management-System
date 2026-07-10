package com.ankit.school_management.repository;

import com.ankit.school_management.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository
        extends JpaRepository<Exam, Long> {

    // Find by Subject
    List<Exam> findBySubject(
            String subject);

    // Search by Subject
    List<Exam> findBySubjectContaining(
            String subject);

    // Find by Max Marks
    List<Exam> findByMaxMarks(
            int maxMarks);
}