package com.edu.ismt.databaseproject.dao;

import com.edu.ismt.databaseproject.entity.OrderDetail;
import java.util.List;

public interface OrderDetailDao {
    List<OrderDetail> getAll();
    OrderDetail getById(int id);
    void save(OrderDetail orderDetail);
    void delete(int id);
}
