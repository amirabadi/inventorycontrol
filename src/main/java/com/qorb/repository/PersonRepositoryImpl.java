package com.qorb.repository;

import com.qorb.model.Person;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class PersonRepositoryImpl implements PersonRepositoryCustome {
    @PersistenceContext

    private EntityManager em;
    @Autowired
    PersonRepository personRepository;

    @Override
    public DataSourceResult getAllKendo(DataSourceRequest request,Class<Person> p) {
        em=em.getEntityManagerFactory().createEntityManager();
        Session session = (Session) em.unwrap(Session.class);
        return request.toDataSourceResult(session, p);
    }
}
