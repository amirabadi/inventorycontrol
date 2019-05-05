package com.qorb.repository;

import com.qorb.model.EquityReceiver;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EquityReceiverRepositoryImpl implements EquityReceiverRepositoryCustome {
    @PersistenceContext

    private EntityManager em;
    @Autowired
    PersonRepository personRepository;

    @Override
    public DataSourceResult getAllKendo(DataSourceRequest request, Class<EquityReceiver> p) {
        em=em.getEntityManagerFactory().createEntityManager();
        Session session = (Session) em.unwrap(Session.class);
        return request.toDataSourceResult(session, p);
    }
}
