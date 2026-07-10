package com.ankit.school_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // Default Constructor
    public User() {
    }

    // Parameterized Constructor
    public User(
            String username,
            String password,
            Role role) {

        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(
            String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(
            String password) {
        this.password = password;
    }

    // Getter for role
    public Role getRole() {
        return role;
    }

    // Setter for role
    public void setRole(
            Role role) {
        this.role = role;
    }
}