package com.edu.ismt.databaseproject.service;

import com.edu.ismt.databaseproject.entity.OrderDetail;
import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> getAll();
    OrderDetail getById(int id);
    void save(OrderDetail orderDetail);
    void delete(int id);
}
