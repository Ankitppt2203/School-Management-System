package com.ankit.school_management.repository;

import com.ankit.school_management.entity.Attendance;
import com.ankit.school_management.entity.AttendanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository
        extends JpaRepository<Attendance, Long> {

    // Find attendance by student
    List<Attendance> findByStudentId(
            Long studentId);

    // Find attendance by date
    List<Attendance> findByDate(
            LocalDate date);

    // Find attendance by status
    List<Attendance> findByStatus(
            AttendanceStatus status);

    // Find attendance by student and date
    List<Attendance> findByStudentIdAndDate(
            Long studentId,
            LocalDate date);
}