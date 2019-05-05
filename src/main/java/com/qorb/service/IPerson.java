package com.qorb.service;

import com.qorb.model.Person;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;

import java.util.List;
import java.util.Map;

public interface IPerson {
    List<Person> getAllPersons();

    DataSourceResult getAllPersons(DataSourceRequest request);
    Person createPerson(Map<String, Object> model);
    Person updatePerson(Map<String, Object> model);
    Person deletePerson(Map<String, Object> model);
}
