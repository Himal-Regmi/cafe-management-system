package com.edu.ismt.databaseproject.service;

import com.edu.ismt.databaseproject.entity.Payment;
import java.util.List;

public interface PaymentService {
    List<Payment> getAll();
    Payment getById(int id);
    void save(Payment payment);
    void delete(int id);
}
