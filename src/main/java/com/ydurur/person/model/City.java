package com.ydurur.person.model;

/**
 * @author ydurur
 */
public class City {

    private String cityName;
    private Long cityPlateNumber;
    private Long cityId;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCityPlateNumber() {
        return cityPlateNumber;
    }

    public void setCityPlateNumber(Long cityPlateNumber) {
        this.cityPlateNumber = cityPlateNumber;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
