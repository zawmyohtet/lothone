package com.zawmyohtet.lothone.model;

/**
 * @author zawmyohtet
 * @since 8/8/16
 */

public class EmergencyContact {

    private static final String TAG = "EmergencyContact";

    private int id;
    private String name, contactNumber, address, type, township, city, latitude, longitude;

    public EmergencyContact() {

    }

    public EmergencyContact(int id, String name, String address, String township, String city, String contactNumber, String latitude, String longitude, String type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.township = township;
        this.city = city;
        this.contactNumber = contactNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
