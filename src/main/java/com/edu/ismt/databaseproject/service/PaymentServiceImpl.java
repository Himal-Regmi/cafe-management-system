package com.edu.ismt.databaseproject.service;

import com.edu.ismt.databaseproject.dao.PaymentDao;
import com.edu.ismt.databaseproject.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    PaymentDao paymentDao;

    @Override
    @Transactional
    public List<Payment> getAll() {
        return paymentDao.getAll();
    }
    @Override
    @Transactional
    public Payment getById(int id) {
        return paymentDao.getById(id);
    }

    @Override
    @Transactional
    public void save(Payment payment) {
        paymentDao.save(payment);
    }

    @Override
    @Transactional
    public void delete(int id) {
        paymentDao.delete(id);
    }
}
