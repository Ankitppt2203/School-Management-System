package com.ankit.school_management.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(
            value = 1,
            message = "Age must be greater than 0")
    private int age;

    @NotNull(message = "Department Id is required")
    private Long departmentId;

    public StudentDTO() {
    }

    public StudentDTO(
            String name,
            int age,
            Long departmentId) {

        this.name = name;
        this.age = age;
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}