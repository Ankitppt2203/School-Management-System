package com.ankit.school_management.repository;

import com.ankit.school_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);

    List<Student> findByAgeGreaterThan(int age);

    List<Student> findByNameContaining(String name);

    List<Student> findByNameAndAge(
            String name,
            int age);

    @Query(
            "SELECT s FROM Student s WHERE s.age > :age")
    List<Student> getStudentsOlderThan(
            @Param("age") int age);
}