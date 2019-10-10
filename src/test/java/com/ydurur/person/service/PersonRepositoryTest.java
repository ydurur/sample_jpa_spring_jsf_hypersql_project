package com.ydurur.person.service;

import com.ydurur.person.model.Person;
import com.ydurur.person.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ydurur
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @TestConfiguration
    static class PersonServiceImplTestContextConfiguration {

        @Bean
        public PersonService personService() {
            return new PersonServiceImpl();
        }
    }

    @Autowired
    PersonService personService;

    Person person =  new Person();

    @Before
    public void setUp(){

        person.setCityName("Manisa");
        person.setDistrictName("Alaybey");
        person.setExplanation("Deneme"+person.getCityName());
        person.setMobileNumber("(535)828 3919");
        person.setName("Yener");
        person.setSurname("Durur");
        person.setPersonId(2L);

        personService.addPerson(person);
    }

    @Test
    public void testSavePerson() throws Exception {

        List<Person> personList = personService.getAllPerson();
        assertTrue(personList.size()>=1);

    }

    @Test
    public void testUpdatePerson() throws Exception {

        person.setName("Updated Ad");
        personService.updatePerson(person);

        List<Person>personList = personService.getAllPerson();
        assertTrue(personList.get(0).getName() == "Updated Ad");

    }
    @Test
    public void testdeletePerson() throws Exception {


        personService.deletePerson(person);

        List<Person>personList = personService.getAllPerson();
        assertTrue(personList.size() == 0);

    }
}
