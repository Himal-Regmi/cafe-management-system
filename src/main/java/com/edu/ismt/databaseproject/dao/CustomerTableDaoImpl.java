package com.edu.ismt.databaseproject.dao;

import com.edu.ismt.databaseproject.entity.CustomerTable;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerTableDaoImpl implements CustomerTableDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<CustomerTable> getAll() {
        Session session= entityManager.unwrap(Session.class);
        Query<CustomerTable> query= session.createQuery("from CustomerTable",CustomerTable.class);
        return query.getResultList();
    }

    @Override
    public CustomerTable getById(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<CustomerTable> query= session.createQuery("from CustomerTable where id = :id",CustomerTable.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(CustomerTable customerTable) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(customerTable);
    }

    @Override
    public void delete(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<CustomerTable> query= session.createQuery("from CustomerTable where id = :id",CustomerTable.class);
        query.setParameter("id",id);
        session.delete(query.getSingleResult());
    }
}
