package com.vehicle.workshop.enums;

public enum GenderEnum {

    MALE("Male"),
    FEMALE("Female");

    private String gender;

    GenderEnum(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
