package com.ankit.school_management.repository;

import com.ankit.school_management.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository
        extends JpaRepository<Course, Long> {

    List<Course> findByName(
            String name);

    List<Course> findByNameContaining(
            String name);
}