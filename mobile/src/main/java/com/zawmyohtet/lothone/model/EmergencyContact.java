package com.zawmyohtet.lothone.model;

/**
 * @author zawmyohtet
 * @since 8/8/16
 */

public class EmergencyContact {

    private static final String TAG = "EmergencyContact";

    private int id;
    private String name, contactNumber, address, type;

    public EmergencyContact(){

    }

    public EmergencyContact(int id, String name, String contactNumber, String address, String type){
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
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
}
