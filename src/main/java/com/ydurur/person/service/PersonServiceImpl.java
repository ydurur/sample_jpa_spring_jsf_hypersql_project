package com.ydurur.person.service;

import com.ydurur.person.repository.PersonRepository;
import com.ydurur.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void addPerson(Person person)
    {
        personRepository.save(person);
        System.out.println(person.toString());
    }

    @Override
    public List<Person> getAllPerson() {
        personRepository.findAll().forEach(personList :: add);
        return  personList;
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.deleteById(person.getPersonId());

    }


}
