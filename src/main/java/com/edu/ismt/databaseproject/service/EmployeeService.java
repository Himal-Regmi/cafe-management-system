package com.edu.ismt.databaseproject.service;

import com.edu.ismt.databaseproject.entity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(int id);
    void save(Employee employee);
    void delete(int id);
}
