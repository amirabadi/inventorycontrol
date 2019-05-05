package com.qorb.repository;

import com.qorb.model.User;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserRepositoryImpl implements UserRepositoryCustome {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    PersonRepository personRepository;

    @Override
    public DataSourceResult getAllKendo(DataSourceRequest request, Class<User> p) {
        em=em.getEntityManagerFactory().createEntityManager();
        Session session = (Session) em.unwrap(Session.class);
        return request.toDataSourceResult(session, p);
    }
}
