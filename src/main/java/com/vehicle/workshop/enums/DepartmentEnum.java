package com.vehicle.workshop.enums;

public enum DepartmentEnum {

    SERVICE("Service"),
    FRONT_OFFICE("Front Office");

    private String departmentEnum;

    DepartmentEnum(String departmentEnum) {
        this.departmentEnum = departmentEnum;
    }

    public String getDepartmentEnum() {
        return departmentEnum;
    }
}
