package com.zawmyohtet.lothone.model;

/**
 * @author zawmyohtet
 * @since 8/19/20
 */

public class UsefulCode {

    private int id;
    private String code, township, city, country, type;

    public UsefulCode(){

    }

    public UsefulCode(int id, String code, String township, String city, String country, String type){
        this.id = id;
        this.code = code;
        this.township = township;
        this.city = city;
        this.country = country;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
