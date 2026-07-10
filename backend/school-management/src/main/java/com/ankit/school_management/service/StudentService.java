package com.ankit.school_management.service;

import com.ankit.school_management.DTO.StudentDTO;
import com.ankit.school_management.entity.Department;
import com.ankit.school_management.entity.Student;
import com.ankit.school_management.exception.StudentNotFoundException;
import com.ankit.school_management.repository.DepartmentRepository;
import com.ankit.school_management.repository.StudentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ankit.school_management.DTO.StudentResponseDTO;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    public StudentService(
            StudentRepository studentRepository,
            DepartmentRepository departmentRepository) {

        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    // ==========================
    // CREATE STUDENT
    // ==========================

    public StudentDTO saveStudent(
            StudentDTO studentDTO) {

        Department department =
                departmentRepository.findById(
                                studentDTO.getDepartmentId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Department not found"));

        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setDepartment(department);

        Student savedStudent =
                studentRepository.save(student);

        return new StudentDTO(
                savedStudent.getName(),
                savedStudent.getAge(),
                savedStudent.getDepartment().getId());
    }

    // ==========================
    // GET ALL STUDENTS
    // ==========================

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }


    // ==========================
// GET ALL STUDENTS (DTO)
// ==========================

    public List<StudentResponseDTO> getAllStudentsDTO() {

        return studentRepository.findAll()
                .stream()
                .map(student -> new StudentResponseDTO(

                        student.getId(),

                        student.getName(),

                        student.getAge()

                ))
                .collect(Collectors.toList());
    }

    // ==========================
    // GET STUDENT BY ID
    // ==========================

    public Student getStudentById(
            Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student with id "
                                        + id
                                        + " not found"));
    }

    // ==========================
// GET STUDENT BY ID (DTO)
// ==========================

    public StudentResponseDTO getStudentByIdDTO(
            Long id) {

        Student student =
                studentRepository.findById(id)
                        .orElseThrow(() ->
                                new StudentNotFoundException(
                                        "Student with id "
                                                + id
                                                + " not found"));

        return new StudentResponseDTO(

                student.getId(),

                student.getName(),

                student.getAge()

        );
    }

    // ==========================
    // UPDATE STUDENT
    // ==========================

    public StudentDTO updateStudent(
            Long id,
            StudentDTO studentDTO) {

        Student student =
                studentRepository.findById(id)
                        .orElseThrow(() ->
                                new StudentNotFoundException(
                                        "Student with id "
                                                + id
                                                + " not found"));

        Department department =
                departmentRepository.findById(
                                studentDTO.getDepartmentId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Department not found"));

        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setDepartment(department);

        Student updatedStudent =
                studentRepository.save(student);

        return new StudentDTO(
                updatedStudent.getName(),
                updatedStudent.getAge(),
                updatedStudent.getDepartment().getId());
    }

    // ==========================
    // DELETE STUDENT
    // ==========================

    public void deleteStudent(
            Long id) {

        studentRepository.deleteById(id);
    }

    // ==========================
    // FIND BY NAME
    // ==========================

    public List<Student> getStudentsByName(
            String name) {

        return studentRepository.findByName(name);
    }

    // ==========================
    // AGE GREATER THAN
    // ==========================

    public List<Student> getStudentsOlderThan(
            int age) {

        return studentRepository.findByAgeGreaterThan(age);
    }

    // ==========================
    // SEARCH NAME
    // ==========================

    public List<Student> searchStudentsByName(
            String name) {

        return studentRepository.findByNameContaining(name);
    }

    // ==========================
    // NAME + AGE
    // ==========================

    public List<Student> getStudentsByNameAndAge(
            String name,
            int age) {

        return studentRepository.findByNameAndAge(name, age);
    }

    // ==========================
    // CUSTOM QUERY
    // ==========================

    public List<Student> getStudentsOlderThanQuery(
            int age) {

        return studentRepository.getStudentsOlderThan(age);
    }

    // ==========================
    // PAGINATION
    // ==========================

    public Page<Student> getStudentsPage(
            int page,
            int size) {

        return studentRepository.findAll(
                PageRequest.of(page, size));
    }

    // ==========================
    // PAGINATION + SORTING
    // ==========================

    public Page<Student> getStudentsPageSorted(
            int page,
            int size,
            String sortBy,
            String direction) {

        Sort sort =
                direction.equalsIgnoreCase("desc")
                        ? Sort.by(sortBy).descending()
                        : Sort.by(sortBy).ascending();

        return studentRepository.findAll(
                PageRequest.of(page, size, sort));
    }
}