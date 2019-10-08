package com.ydurur.person.service;

import com.ydurur.person.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ydurur
 */
@Component
public class PersonRepositoryTest {
    @Autowired
    PersonService personService;
    @Test
    public void testSavePerson() throws Exception {
        Person person =  new Person();
        person.setCityId(2);
        person.setDistrictId(3L);
        person.setExplanation("Deneme"+person.getCityId());
        person.setMobileNumber("(535)828 3919");
        person.setName("Yener");
        person.setSurname("Durur");
        person.setPersonId(1L);

        personService.addPerson(person);

    }
}
