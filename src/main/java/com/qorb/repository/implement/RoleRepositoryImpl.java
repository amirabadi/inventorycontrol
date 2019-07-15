package com.qorb.repository.implement;

import com.qorb.model.Role;
import com.qorb.repository.PersonRepository;
import com.qorb.repository.RoleRepositoryCustome;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RoleRepositoryImpl implements RoleRepositoryCustome {
    @PersistenceContext

    private EntityManager em;
    @Autowired
    PersonRepository personRepository;

    @Override
    public DataSourceResult getAllKendo(DataSourceRequest request,Class<Role>p) {
        em=em.getEntityManagerFactory().createEntityManager();
        Session session = (Session) em.unwrap(Session.class);
        return request.toDataSourceResult(session, p);
    }
}
