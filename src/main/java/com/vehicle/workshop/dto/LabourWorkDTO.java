package com.vehicle.workshop.dto;

public class LabourWorkDTO extends BaseEntityDTO {

    private String workStatus;

    private Long serviceId;

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}
