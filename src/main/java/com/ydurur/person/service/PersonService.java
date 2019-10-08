package com.ydurur.person.service;

import com.ydurur.person.model.Person;

import java.util.List;

/**
 * @author ydurur
 */
public interface PersonService {

    void addPerson(Person person);
    List<Person> getAllPerson();
    void updatePerson(Person person);
    void deletePerson(Person person);
}
