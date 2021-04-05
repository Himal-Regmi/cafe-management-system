package com.edu.ismt.databaseproject.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="customer_table")
public class CustomerTable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    @NotBlank(message = "REQUIRED")
    private String location;
    public CustomerTable() {
    }

    public CustomerTable(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
