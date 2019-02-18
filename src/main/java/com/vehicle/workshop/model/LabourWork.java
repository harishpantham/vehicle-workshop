package com.vehicle.workshop.model;

import javax.persistence.Entity;

@Entity
public class LabourWork extends BaseEntity {

    private String workStatus;

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
}
