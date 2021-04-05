package com.edu.ismt.databaseproject.dao;

import com.edu.ismt.databaseproject.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAll() {
        Session session= entityManager.unwrap(Session.class);
        Query<Employee> query= session.createQuery("from Employee",Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getById(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Employee> query= session.createQuery("from Employee where id = :id",Employee.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void delete(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Employee> query= session.createQuery("from Employee where id = :id",Employee.class);
        query.setParameter("id",id);
        session.delete(query.getSingleResult());
    }
}
