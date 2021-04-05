package com.edu.ismt.databaseproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "REQUIRED")
    @Size(min = 3, message = "Name must be more than 2 character")
    private String name;
    @NotBlank(message = "REQUIRED")
    @Size(min = 8, message = "Password must be more than 8 character")
    private String password;
    private String address;
    private Long phoneNumber;
    @NotBlank(message = "REQUIRED")
    private String role;

    public Employee() {
    }

    public Employee(int id, String name, String password, String address, Long phoneNumber, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
