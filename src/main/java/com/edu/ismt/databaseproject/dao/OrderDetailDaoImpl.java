package com.edu.ismt.databaseproject.dao;

import com.edu.ismt.databaseproject.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<OrderDetail> getAll() {
        Session session= entityManager.unwrap(Session.class);
        Query<OrderDetail> query= session.createQuery("from OrderDetail",OrderDetail.class);
        return query.getResultList();
    }

    @Override
    public OrderDetail getById(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<OrderDetail> query= session.createQuery("from OrderDetail where id = :id",OrderDetail.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(OrderDetail orderDetail) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(orderDetail);
    }

    @Override
    public void delete(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<OrderDetail> query= session.createQuery("from OrderDetail where id = :id",OrderDetail.class);
        query.setParameter("id",id);
        session.delete(query.getSingleResult());
    }
}
