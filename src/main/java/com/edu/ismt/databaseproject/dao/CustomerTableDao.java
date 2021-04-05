package com.edu.ismt.databaseproject.dao;

import com.edu.ismt.databaseproject.entity.CustomerTable;
import java.util.List;

public interface CustomerTableDao {
    List<CustomerTable> getAll();
    CustomerTable getById(int id);
    void save(CustomerTable customerTable);
    void delete(int id);
}
