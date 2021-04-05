package com.edu.ismt.databaseproject.dao;

import com.edu.ismt.databaseproject.entity.Employee;
import java.util.List;

public interface EmployeeDao {
    List<Employee> getAll();
    Employee getById(int id);
    void save(Employee employee);
    void delete(int id);
}
