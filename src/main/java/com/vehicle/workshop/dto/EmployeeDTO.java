package com.vehicle.workshop.dto;

import com.vehicle.workshop.enums.DepartmentEnum;
import com.vehicle.workshop.enums.EmployeeStatusEnum;
import com.vehicle.workshop.enums.GenderEnum;

import javax.validation.constraints.Email;

public class EmployeeDTO extends BaseEntityDTO {

    private Long dateOfJoining;

    private DepartmentEnum departmentEnum;

    private String designation;

    private String name;

    private GenderEnum genderEnum;

    private String fatherOrHusbandName;

    private String address;

    private String city;

    private String mobileNumber;

    private String pin;

    private String landLineNumber;

    private String state;

    private String panNumber;

    @Email
    private String email;

    private EmployeeStatusEnum employeeStatusEnum;

    private Long franchiseId;

    public Long getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Long dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public DepartmentEnum getDepartmentEnum() {
        return departmentEnum;
    }

    public void setDepartmentEnum(DepartmentEnum departmentEnum) {
        this.departmentEnum = departmentEnum;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderEnum getGenderEnum() {
        return genderEnum;
    }

    public void setGenderEnum(GenderEnum genderEnum) {
        this.genderEnum = genderEnum;
    }

    public String getFatherOrHusbandName() {
        return fatherOrHusbandName;
    }

    public void setFatherOrHusbandName(String fatherOrHusbandName) {
        this.fatherOrHusbandName = fatherOrHusbandName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getLandLineNumber() {
        return landLineNumber;
    }

    public void setLandLineNumber(String landLineNumber) {
        this.landLineNumber = landLineNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeStatusEnum getEmployeeStatusEnum() {
        return employeeStatusEnum;
    }

    public void setEmployeeStatusEnum(EmployeeStatusEnum employeeStatusEnum) {
        this.employeeStatusEnum = employeeStatusEnum;
    }

    public Long getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(Long franchiseId) {
        this.franchiseId = franchiseId;
    }
}
