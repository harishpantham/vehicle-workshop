package com.vehicle.workshop.enums;

public enum EmployeeStatusEnum {

    ACTIVE("ACTIVE"),
    CONTINUE("CONTINUE"),
    TERMINATED("TERMINATED");

    private String empStatus;

    EmployeeStatusEnum(String gender) {
        this.empStatus = empStatus;
    }

    public String getGender() {
        return empStatus;
    }
}
