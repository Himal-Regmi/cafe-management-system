package com.edu.ismt.databaseproject.service;

import com.edu.ismt.databaseproject.entity.Orders;
import java.util.List;

public interface OrderService {
    List<Orders> getAll();
    Orders getById(int id);
    void save(Orders orders);
    void delete(int id);
}
