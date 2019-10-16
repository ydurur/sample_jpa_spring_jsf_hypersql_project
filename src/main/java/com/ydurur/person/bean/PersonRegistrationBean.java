package com.ydurur.person.bean;

import com.ydurur.person.model.Person;
import com.ydurur.person.service.PersonService;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @implNote Bu sını jsf bean olarak kullanılırçindexn html de  alanaları karsılamak için kullanılır
 * @author ydurur
 */

@Component
@ViewScoped
public class PersonRegistrationBean implements Serializable
{
    @Autowired
    PersonService personService;

    @NotNull
    @Max(value = 999999999)
    private Long personId;

    @NotBlank
    @Size(min = 2, max = 20)
    private String name;

    @NotBlank
    @Size(min = 2, max = 20)
    private String surname;

    @NotBlank
    @Size(min = 14, max = 14)
    private String mobileNumber;

    @NotBlank
    @Size(min = 2, max = 20)
    private String districtName;

    @Size(min = 2, max = 160)
    private String explanation;

    @NotBlank
    @Size(min = 2, max = 20)
    private String cityName;

    private Map<String, Map<String,String>> data = new HashMap<>();
    private String city;
    private String district;
    private Map<String, String> cities;
    private Map<String,String> districts;

    private List<Person> personList ;

    private Person person ;

    @PostConstruct
    public void init() {
        {
            cities  = new HashMap<>();
            cities.put("Ankara", "Ankara");
            cities.put("İstanbul", "İstanbul");
            cities.put("İzmir", "İzmir");
            cities.put("Manisa", "Manisa");

            Map<String,String> map = new HashMap<>();
            map.put("Çankaya", "Çankaya");
            map.put("Keçiören", "Keçiören");
            map.put("Sincan","Sincan");
            data.put("Ankara", map);

            map = new HashMap<>();
            map.put("Kadiköy", "Kadiköy");
            map.put("Tuzla", "Kadiköy");
            map.put("Başakşehir", "Kadiköy");
            data.put("İstanbul", map);

            map = new HashMap<>();
            map.put("Karşıyaka", "Karşıyaka");
            map.put("Göztepe", "Karşıyaka");
            map.put("Güzelbahçe", "Güzelbahçe");
            data.put("İzmir", map);

            map = new HashMap<>();
            map.put("Alaybey", "Alaybey");
            map.put("Karaköy", "Karaköy");
            map.put("Kırkağaç", "Kırkağaç");
            data.put("Manisa", map);

            personList = personService.getAllPerson();
        }

    }

    public void onCityChange() {
        if(cityName !=null && !cityName.equals(""))
            districts = data.get(cityName);
        else
            districts = new HashMap<>();
    }

    public void onCityChangeInList(AjaxBehaviorEvent event) {
        String cityName = event.getComponent().getAttributes().get("citySelect").toString();
        if(!cityName.equals(null)) {
            districts = data.get(cityName);
        } else{
                districts = new HashMap<>();
        }
    }

    public void onRowEditInit(AjaxBehaviorEvent event) {
        String cityName = event.getComponent().getAttributes().get("citySelectInit").toString();
        if(!cityName.equals(null)) {
            districts = data.get(cityName);
        } else{
            districts = new HashMap<>();
        }
    }


    public void onRowEdit(RowEditEvent event){

        Person person = (Person) event.getObject();
        personService.updatePerson(person);
        FacesMessage msg = new FacesMessage("Person Edited", ((Person) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Person) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCityName() { return cityName;}

    public void setCityName(String cityName) { this.cityName = cityName;  }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Long getPersonId() { return personId;   }

    public void setPersonId(Long personId) {   this.personId = personId;  }

    public void setCities(HashMap<String, String> cities) {
        this.cities = cities;
    }

    public Map<String, Map<String, String>> getData() {return data; }

    public void setData(Map<String, Map<String, String>> data) { this.data = data;  }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

    public Map<String, String> getDistricts() {
        return districts;
    }

    public void setDistricts(Map<String, String> districts) {
        this.districts = districts;
    }

    public List<Person> getPersonList() {  return personList;  }

    public void setPersonList(List<Person> personList) {   this.personList = personList; }

    public Person getPerson() { return person; }

    public void setPerson(Person person) { this.person = person; }
}
