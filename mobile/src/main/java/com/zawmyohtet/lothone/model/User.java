package com.zawmyohtet.lothone.model;

/**
 * @author zawmyohtet
 * @since 8/3/16
 */

public class User {

    private int id;
    private String name;
    private String gender;
    private String bloodType;
    private String address;
    private String emergencyNumberOne;
    private String emergencyNumberTwo;
    private String emergencyNumberThree;
    private String createdAt;
    private String updatedAt;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergencyNumberOne() {
        return emergencyNumberOne;
    }

    public void setEmergencyNumberOne(String emergencyNumberOne) {
        this.emergencyNumberOne = emergencyNumberOne;
    }

    public String getEmergencyNumberTwo() {
        return emergencyNumberTwo;
    }

    public void setEmergencyNumberTwo(String emergencyNumberTwo) {
        this.emergencyNumberTwo = emergencyNumberTwo;
    }

    public String getEmergencyNumberThree() {
        return emergencyNumberThree;
    }

    public void setEmergencyNumberThree(String emergencyNumberThree) {
        this.emergencyNumberThree = emergencyNumberThree;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
