package com.expenses.service;

import com.expenses.entity.Person;

import java.util.List;

/**
 * Created by gnester on 2015-10-29.
 */
public interface PersonService {

    Iterable<Person> listAllPersons();

    Person getPersonById(Integer id);

    Person savePerson(Person person);

    void deletePerson(Integer id);

}
