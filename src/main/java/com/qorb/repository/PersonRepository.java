package com.qorb.repository;

import com.qorb.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer>,PersonRepositoryCustome {

    Person findByIdPerson(int id);
    List<Person> findAll();
}
