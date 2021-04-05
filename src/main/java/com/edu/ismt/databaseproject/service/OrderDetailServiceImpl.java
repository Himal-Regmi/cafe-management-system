package com.edu.ismt.databaseproject.service;

import com.edu.ismt.databaseproject.dao.OrderDetailDao;
import com.edu.ismt.databaseproject.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailDao orderDetailDao;

    @Override
    @Transactional
    public List<OrderDetail> getAll() {
        return orderDetailDao.getAll();
    }
    @Override
    @Transactional
    public OrderDetail getById(int id) {
        return orderDetailDao.getById(id);
    }

    @Override
    @Transactional
    public void save(OrderDetail orderDetail) {
        orderDetailDao.save(orderDetail);
    }

    @Override
    @Transactional
    public void delete(int id) {
        orderDetailDao.delete(id);
    }
}
