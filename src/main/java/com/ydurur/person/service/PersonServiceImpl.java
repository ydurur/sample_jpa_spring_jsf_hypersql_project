package com.ydurur.person.service;

import com.ydurur.person.repository.PersonRepository;
import com.ydurur.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author ydurur
 */
@Service
public class PersonServiceImpl  implements PersonService
{
    @Autowired
    PersonRepository personRepository;

    private List<Person> personList;

    @Override
    @Transactional
    public void addPerson(Person person)
    {
        personRepository.save(person);
        System.out.println(person.toString());
    }

    @Override
    @Transactional
    public List<Person> getAllPerson() {
        personList = personRepository.findAll();
        return  personList;
    }

    @Override
    @Transactional
    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.deleteById(person.getPersonId());

    }

    @Override
    public Person findByPersonId(Long personId) {
        Person person = personRepository.findByPersonId(personId);
        return person;
    }
}
