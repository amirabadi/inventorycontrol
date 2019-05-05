package com.qorb.repository;

import com.qorb.model.Person;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;

public interface PersonRepositoryCustome {
    DataSourceResult getAllKendo(DataSourceRequest request, Class<Person> p);
}
