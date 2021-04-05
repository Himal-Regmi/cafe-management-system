package com.edu.ismt.databaseproject.dao;

import com.edu.ismt.databaseproject.entity.Orders;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Orders> getAll() {
        Session session= entityManager.unwrap(Session.class);
        Query<Orders> query= session.createQuery("from Orders", Orders.class);
        return query.getResultList();
    }

    @Override
    public Orders getById(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Orders> query= session.createQuery("from Orders where id = :id", Orders.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Orders orders) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(orders);
    }

    @Override
    public void delete(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Orders> query= session.createQuery("from Orders where id = :id", Orders.class);
        query.setParameter("id",id);
        session.delete(query.getSingleResult());
    }
}
