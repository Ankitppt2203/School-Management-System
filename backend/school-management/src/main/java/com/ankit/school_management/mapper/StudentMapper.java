package com.ankit.school_management.mapper;

import com.ankit.school_management.DTO.StudentDTO;
import com.ankit.school_management.entity.Student;

public class StudentMapper {

    public static Student toEntity(
            StudentDTO studentDTO) {

        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());

        return student;
    }

    public static StudentDTO toDTO(
            Student student) {

        Long departmentId = null;

        if (student.getDepartment() != null) {
            departmentId =
                    student.getDepartment().getId();
        }

        return new StudentDTO(
                student.getName(),
                student.getAge(),
                departmentId);
    }
}