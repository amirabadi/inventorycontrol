package com.qorb.repository.implement;

import com.qorb.model.Permission;
import com.qorb.repository.PermissionRepositoryCustome;
import com.qorb.repository.PersonRepository;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PermissionRepositoryImpl implements PermissionRepositoryCustome {
    @PersistenceContext

    private EntityManager em;
    @Autowired
    PersonRepository personRepository;

    @Override
    public DataSourceResult getAllKendo(DataSourceRequest request, Class<Permission>p) {
        em=em.getEntityManagerFactory().createEntityManager();
        Session session = (Session) em.unwrap(Session.class);
        return request.toDataSourceResult(session, p);
    }
}
