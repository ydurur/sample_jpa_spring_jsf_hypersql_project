package com.ydurur.person.bean;

import com.ydurur.person.model.City;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.validation.constraints.*;
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

    private Long districtId;

    @Size(min = 2, max = 160)
    private String explanation;

    @NotNull
    @Max(99)
    private Integer cityId;

    private Map<Integer, Map<String,Integer>> data = new HashMap<>();
    private String city;
    private String district;
    private Map<String, Integer> cities;
    private Map<String,Integer> districts;

    @PostConstruct
    public void init() {
        {
            cities  = new HashMap<>();
            cities.put("Ankara", 6);
            cities.put("İstanbul", 34);
            cities.put("İzmir", 35);
            cities.put("Manisa", 45);

            Map<String,Integer> map = new HashMap<>();
            map.put("Çankaya", 1);
            map.put("Keçiören", 2);
            map.put("Sincan",3);
            data.put(6, map);

            map = new HashMap<>();
            map.put("Kadiköy", 4);
            map.put("Tuzla", 5);
            map.put("Başakşehir", 6);
            data.put(34, map);

            map = new HashMap<>();
            map.put("Karşıyaka", 7);
            map.put("Göztepe", 8);
            map.put("Güzelbahçe", 9);
            data.put(35, map);

            map = new HashMap<>();
            map.put("Alaybey", 10);
            map.put("Karaköy", 11);
            map.put("Kırkağaç", 12);
            data.put(45, map);
        }

    }

    public void onCityChange() {
        if(cityId !=null && !cityId.equals(""))
            districts = data.get(cityId);
        else
            districts = new HashMap<>();
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

    public Integer getCityId() { return cityId;}

    public void setCityId(Integer cityId) { this.cityId = cityId;  }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Long getPersonId() { return personId;   }

    public void setPersonId(Long personId) {   this.personId = personId;  }

    public void setCities(HashMap<String, Integer> cities) {
        this.cities = cities;
    }

    public Map<Integer, Map<String, Integer>> getData() {return data; }

    public void setData(Map<Integer, Map<String, Integer>> data) { this.data = data;  }

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

    public Map<String, Integer> getCities() {
        return cities;
    }

    public void setCities(Map<String, Integer> cities) {
        this.cities = cities;
    }

    public Map<String, Integer> getDistricts() {
        return districts;
    }

    public void setDistricts(Map<String, Integer> districts) {
        this.districts = districts;
    }
}
