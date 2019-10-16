package com.ydurur.person.action;

import com.ydurur.person.bean.PersonRegistrationBean;
import com.ydurur.person.model.Person;
import com.ydurur.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * @implNote jsf deki  eventleri yakalayan sınıftır.
 * @author ydurur
 */

@Component
@RequestScope
public class PersonRegistrationAction implements Serializable
{
    private final PersonRegistrationBean personRegistrationBean;
    private final PersonService personService;

    public PersonRegistrationAction(@Autowired PersonRegistrationBean personRegistrationBean,
                                    @Autowired PersonService personService)
    {
        this.personRegistrationBean = personRegistrationBean;
        this.personService = personService;
    }

    public List<Person> getAllPerson(){
        List<Person> personList = personService.getAllPerson();
        return  personList;
    }

    private Person person=null;


    public void savePerson() throws SQLException {
        createPersonObjectFromView();
        personService.addPerson(person);

    }

    public void deletePerson(String Id)
    {
        Person  person = personService.findByPersonId(Long.parseLong(Id));
        personService.deletePerson(person);
    }


    public void createPersonObjectFromView()  {
        person = new Person();
        person.setPersonId(personRegistrationBean.getPersonId());
        person.setCityName(personRegistrationBean.getCityName());
        person.setMobileNumber(personRegistrationBean.getMobileNumber());
        person.setName(personRegistrationBean.getName());
        person.setSurname(personRegistrationBean.getSurname());
        person.setDistrictName(personRegistrationBean.getDistrictName());
        person.setExplanation(personRegistrationBean.getExplanation());
        System.out.println(FacesContext.class.getPackage().getImplementationVersion());
    }




}
