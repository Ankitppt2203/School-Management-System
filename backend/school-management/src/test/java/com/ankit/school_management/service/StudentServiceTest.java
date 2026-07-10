package com.ankit.school_management.service;

import com.ankit.school_management.DTO.StudentDTO;
import com.ankit.school_management.entity.Department;
import com.ankit.school_management.entity.Student;
import com.ankit.school_management.exception.StudentNotFoundException;
import com.ankit.school_management.repository.DepartmentRepository;
import com.ankit.school_management.repository.StudentRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.ArgumentCaptor;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private StudentService studentService;

    // =====================================
    // Test Save Student
    // =====================================

    @Test
    void testSaveStudent() {

        StudentDTO dto =
                new StudentDTO(
                        "Ankit",
                        23,
                        1L);

        Department department =
                new Department();

        department.setId(1L);
        department.setName(
                "Computer Science");

        Student student =
                new Student();

        student.setName(
                "Ankit");

        student.setAge(23);

        student.setDepartment(
                department);

        when(
                departmentRepository.findById(1L))
                .thenReturn(Optional.of(department));

        when(
                studentRepository.save(any(Student.class)))
                .thenReturn(student);

        StudentDTO savedStudent =
                studentService.saveStudent(dto);

        assertEquals(
                "Ankit",
                savedStudent.getName());

        assertEquals(
                23,
                savedStudent.getAge());

        // Capture Student object
        ArgumentCaptor<Student> studentCaptor =
                ArgumentCaptor.forClass(Student.class);

        verify(studentRepository, times(1))
                .save(studentCaptor.capture());

        verify(departmentRepository, times(1))
                .findById(1L);

        // Get captured object
        Student capturedStudent =
                studentCaptor.getValue();

        // Verify captured object
        assertEquals(
                "Ankit",
                capturedStudent.getName());

        assertEquals(
                23,
                capturedStudent.getAge());

        assertEquals(
                1L,
                capturedStudent.getDepartment().getId());
    }
    // =====================================
    // Test Student Not Found
    // =====================================

    @Test
    void testGetStudentByIdNotFound() {

        when(
                studentRepository.findById(100L))
                .thenReturn(Optional.empty());

        StudentNotFoundException exception =
                assertThrows(
                        StudentNotFoundException.class,
                        () -> studentService.getStudentById(100L));

        assertEquals(
                "Student with id 100 not found",
                exception.getMessage());

        verify(studentRepository, times(1))
                .findById(100L);
    }

    @Test
    void testGetStudentByIdSuccess() {

        Student student = new Student();

        student.setName("Ankit");
        student.setAge(23);

        when(studentRepository.findById(1L))
                .thenReturn(Optional.of(student));

        Student foundStudent =
                studentService.getStudentById(1L);

        assertEquals(
                "Ankit",
                foundStudent.getName());

        assertEquals(
                23,
                foundStudent.getAge());

        verify(studentRepository, times(1))
                .findById(1L);
    }

    @Test
    void testUpdateStudent() {

        // New data coming from client
        StudentDTO dto =
                new StudentDTO(
                        "Ankit Kumar",
                        24,
                        2L);

        // Existing student in database
        Student student =
                new Student();

        student.setName("Ankit");
        student.setAge(23);

        // New Department
        Department department =
                new Department();

        department.setId(2L);
        department.setName("Mechanical Engineering");

        // Mock repository calls
        when(studentRepository.findById(1L))
                .thenReturn(Optional.of(student));

        when(departmentRepository.findById(2L))
                .thenReturn(Optional.of(department));

        when(studentRepository.save(any(Student.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // Call Service
        StudentDTO updatedStudent =
                studentService.updateStudent(
                        1L,
                        dto);

        // Verify updated values
        assertEquals(
                "Ankit Kumar",
                updatedStudent.getName());

        assertEquals(
                24,
                updatedStudent.getAge());

        assertEquals(
                2L,
                updatedStudent.getDepartmentId());

        // Verify repository methods
        verify(studentRepository, times(1))
                .findById(1L);

        verify(departmentRepository, times(1))
                .findById(2L);

        verify(studentRepository, times(1))
                .save(any(Student.class));
    }
}