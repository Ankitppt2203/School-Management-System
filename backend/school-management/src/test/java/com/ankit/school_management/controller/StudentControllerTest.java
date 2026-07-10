package com.ankit.school_management.controller;

import com.ankit.school_management.DTO.StudentDTO;
import com.ankit.school_management.entity.Student;
import com.ankit.school_management.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.security.test.context.support.WithMockUser;

import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.mockito.ArgumentMatchers.any;


@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @MockBean
    private StudentService studentService;



    @Autowired
    private ObjectMapper objectMapper;

    // =====================================
    // CREATE STUDENT
    // =====================================

    @Test
    @WithMockUser(roles = "ADMIN")
    void testAddStudent() throws Exception {

        StudentDTO request =
                new StudentDTO(
                        "Ankit",
                        23,
                        1L);


        StudentDTO response =
                new StudentDTO(
                        "Ankit",
                        23,
                        1L);

        when(studentService.saveStudent(any(StudentDTO.class)))
                .thenReturn(response);

        mockMvc.perform(
                        post("/students")
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ankit"))
                .andExpect(jsonPath("$.age").value(23))
                .andExpect(jsonPath("$.departmentId").value(1));
    }

    // =====================================
    // GET ALL STUDENTS
    // =====================================

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void testGetAllStudents() throws Exception {

        Student student =
                new Student();

        student.setName("Ankit");
        student.setAge(23);

        when(studentService.getAllStudents())
                .thenReturn(List.of(student));

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name")
                        .value("Ankit"))
                .andExpect(jsonPath("$[0].age")
                        .value(23));
    }

    // =====================================
    // GET STUDENT BY ID
    // =====================================

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void testGetStudentById() throws Exception {

        Student student =
                new Student();

        student.setName("Ankit");
        student.setAge(23);

        when(studentService.getStudentById(1L))
                .thenReturn(student);

        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name")
                        .value("Ankit"))
                .andExpect(jsonPath("$.age")
                        .value(23));
    }
}