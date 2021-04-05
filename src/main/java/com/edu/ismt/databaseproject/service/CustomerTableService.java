package com.edu.ismt.databaseproject.service;

import com.edu.ismt.databaseproject.entity.CustomerTable;
import java.util.List;

public interface CustomerTableService {
    List<CustomerTable> getAll();
    CustomerTable getById(int id);
    void save(CustomerTable customerTable);
    void delete(int id);
}
