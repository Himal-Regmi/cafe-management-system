package com.edu.ismt.databaseproject.service;

import com.edu.ismt.databaseproject.dao.CustomerTableDao;
import com.edu.ismt.databaseproject.entity.CustomerTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerTableServiceImpl implements CustomerTableService{
    @Autowired
    CustomerTableDao customerTableDao;

    @Override
    @Transactional
    public List<CustomerTable> getAll() {
        return customerTableDao.getAll();
    }
    @Override
    @Transactional
    public CustomerTable getById(int id) {
        return customerTableDao.getById(id);
    }

    @Override
    @Transactional
    public void save(CustomerTable customerTable) {
        customerTableDao.save(customerTable);
    }

    @Override
    @Transactional
    public void delete(int id) {
        customerTableDao.delete(id);
    }
}
