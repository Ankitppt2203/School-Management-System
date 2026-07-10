package com.ankit.school_management.controller;

import com.ankit.school_management.DTO.StudentDTO;
import com.ankit.school_management.DTO.StudentResponseDTO;
import com.ankit.school_management.entity.Student;
import com.ankit.school_management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // ==========================
    // CREATE STUDENT
    // ==========================
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public StudentDTO addStudent(
            @Valid
            @RequestBody StudentDTO studentDTO) {

        return studentService.saveStudent(studentDTO);
    }

    // ==========================
    // GET ALL STUDENTS (DTO)
    // ==========================
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getStudents() {

        return ResponseEntity.ok(
                studentService.getAllStudentsDTO());
    }

    // ==========================
    // GET STUDENT BY ID (DTO)
    // ==========================
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(
            @PathVariable Long id) {

        return studentService.getStudentByIdDTO(id);
    }

    // ==========================
    // UPDATE STUDENT
    // ==========================
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public StudentDTO updateStudent(
            @PathVariable Long id,
            @Valid
            @RequestBody StudentDTO studentDTO) {

        return studentService.updateStudent(id, studentDTO);
    }

    // ==========================
    // DELETE STUDENT
    // ==========================
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteStudent(
            @PathVariable Long id) {

        studentService.deleteStudent(id);
    }

    // ==========================
    // SEARCH BY NAME
    // ==========================
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @GetMapping("/name/{name}")
    public List<Student> getStudentsByName(
            @PathVariable String name) {

        return studentService.getStudentsByName(name);
    }

    // ==========================
    // AGE GREATER THAN
    // ==========================
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @GetMapping("/age/{age}")
    public List<Student> getStudentsOlderThan(
            @PathVariable int age) {

        return studentService.getStudentsOlderThan(age);
    }

    // ==========================
    // SEARCH LIKE
    // ==========================
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @GetMapping("/search/{name}")
    public List<Student> searchStudentsByName(
            @PathVariable String name) {

        return studentService.searchStudentsByName(name);
    }

    // ==========================
    // NAME + AGE
    // ==========================
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @GetMapping("/{name}/{age}")
    public List<Student> getStudentsByNameAndAge(
            @PathVariable String name,
            @PathVariable int age) {

        return studentService.getStudentsByNameAndAge(name, age);
    }

    // ==========================
    // CUSTOM QUERY
    // ==========================
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @GetMapping("/query/{age}")
    public List<Student> getStudentsOlderThanQuery(
            @PathVariable int age) {

        return studentService.getStudentsOlderThanQuery(age);
    }

    // ==========================
    // PAGINATION
    // ==========================
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @GetMapping("/page")
    public Page<Student> getStudentsPage(

            @RequestParam int page,
            @RequestParam int size) {

        return studentService.getStudentsPage(page, size);
    }

    // ==========================
    // PAGINATION + SORTING
    // ==========================
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @GetMapping("/page-sort")
    public Page<Student> getStudentsPageSorted(

            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String direction) {

        return studentService.getStudentsPageSorted(
                page,
                size,
                sortBy,
                direction);
    }
}