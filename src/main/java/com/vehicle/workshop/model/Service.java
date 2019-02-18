package com.vehicle.workshop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service")
public class Service extends BaseEntity {

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int timeTakenForServiceInMin;

    private Double totalCost;

    @Column(columnDefinition = "TEXT")
    private String remarks;

    @OneToMany(mappedBy = "service", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LabourWork> labourWorkList = new ArrayList<>();

    @OneToMany(mappedBy = "service", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Parts> partsList = new ArrayList<>();

    public void addLabourWork(LabourWork labourWork) {
        labourWorkList.add(labourWork);
        labourWork.setService(this);
    }

    public void removeLabourWork(LabourWork labourWork) {
        labourWork.setService(null);
        this.labourWorkList.remove(labourWork);
    }

    public void addParts(Parts parts) {
        partsList.add(parts);
        parts.setService(this);
    }

    public void removeParts(Parts parts) {
        parts.setService(null);
        this.partsList.remove(parts);
    }

}