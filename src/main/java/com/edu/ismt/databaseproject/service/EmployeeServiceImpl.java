package com.edu.ismt.databaseproject.service;

import com.edu.ismt.databaseproject.dao.EmployeeDao;
import com.edu.ismt.databaseproject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;

    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }
    @Override
    @Transactional
    public Employee getById(int id) {
        return employeeDao.getById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDao.delete(id);
    }
}
