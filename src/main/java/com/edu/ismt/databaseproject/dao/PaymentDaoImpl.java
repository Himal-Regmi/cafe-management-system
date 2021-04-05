package com.edu.ismt.databaseproject.dao;

import com.edu.ismt.databaseproject.entity.Payment;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PaymentDaoImpl implements PaymentDao{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Payment> getAll() {
        Session session= entityManager.unwrap(Session.class);
        Query<Payment> query= session.createQuery("from Payment",Payment.class);
        return query.getResultList();
    }

    @Override
    public Payment getById(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Payment> query= session.createQuery("from Payment where id = :id",Payment.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Payment payment) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(payment);
    }

    @Override
    public void delete(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Payment> query= session.createQuery("from Payment where id = :id",Payment.class);
        query.setParameter("id",id);
        session.delete(query.getSingleResult());
    }
}
