package com.qorb.service;

import com.qorb.model.Person;
import com.qorb.repository.PersonRepository;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PersonImpl implements IPerson{
    @Autowired
    PersonRepository personRepository;
    @Override
    public List<Person> getAllPersons() {
        List<Person>t= personRepository.findAll();
        return t;
    }

    @Override
    public DataSourceResult getAllPersons(DataSourceRequest request) {
        return personRepository.getAllKendo(request,Person.class);
    }

    @Override
    public Person createPerson(Map<String, Object> model) {
        Person person=fillValuesObject(model);
        person.setInsertDate(new Date());
        personRepository.save(person);
        return person;
    }

    @Override
    public Person updatePerson(Map<String, Object> model) {
        Person person=fillValuesObject(model);
        person.setIdPerson((Integer)model.get("idPerson"));
        person.setUpdateDate(new Date());
        personRepository.save(person);
        return person;
    }

    @Override
    public Person deletePerson(Map<String, Object> model) {
        Person person=fillValuesObject(model);
        person.setIdPerson((Integer)model.get("idPerson"));
        personRepository.delete(person);
        return null;
    }

    private Person fillValuesObject(Map<String, Object> model) {
        Person person=new Person();

        person.setName((String) model.get("name"));
        person.setLastName((String) model.get("lastName"));
        person.setNationalCode((String) model.get("nationalCode"));
        return person;
    }
}
