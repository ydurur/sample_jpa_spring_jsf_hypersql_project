package com.ydurur.person.model;

/**
 * @author ydurur
 */
public class District {
    private Long districtId;
    private Long districtCode;
    private Long districtName;
    private Long provinceId;

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Long districtCode) {
        this.districtCode = districtCode;
    }

    public Long getDistrictName() {
        return districtName;
    }

    public void setDistrictName(Long districtName) {
        this.districtName = districtName;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
}
