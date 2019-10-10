package com.ydurur.person.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author ydurur
 * @implNote Bu sınıf entity olarak kullanılmaktadır.
 */
@Entity
public class Person {
    @Id
    private Long personId;

    private String name;
    private String surname;
    private String mobileNumber;
    private String cityName;
    private String districtName;
    private String explanation;

    public Long getPersonId() {return personId;  }

    public void setPersonId(Long personId) {
        this.personId = personId;
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

    public String getCityName() { return cityName; }

    public void setCityName(String cityId) {
        this.cityName = cityId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtId) {
        this.districtName = districtId;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "studentId=" + personId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", cityId=" + cityName +
                ", districtId=" + districtName +
                ", explanation='" + explanation + '\'' +
                '}';
    }
}
