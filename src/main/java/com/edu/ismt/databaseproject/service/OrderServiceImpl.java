package com.edu.ismt.databaseproject.service;

import com.edu.ismt.databaseproject.dao.OrderDao;
import com.edu.ismt.databaseproject.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDao orderDao;

    @Override
    @Transactional
    public List<Orders> getAll() {
        return orderDao.getAll();
    }
    @Override
    @Transactional
    public Orders getById(int id) {
        return orderDao.getById(id);
    }

    @Override
    @Transactional
    public void save(Orders orders) {
        orderDao.save(orders);
    }

    @Override
    @Transactional
    public void delete(int id) {
        orderDao.delete(id);
    }
}
