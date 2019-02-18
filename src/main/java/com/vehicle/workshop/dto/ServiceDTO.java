package com.vehicle.workshop.dto;

import java.util.ArrayList;
import java.util.List;

public class ServiceDTO extends BaseEntityDTO {

    private String name;

    private String description;

    private int timeTakenForServiceInMin;

    private Double totalCost;

    private String remarks;

    private List<LabourWorkDTO> labourWorkList = new ArrayList<>();

    private List<PartsDTO> partsList = new ArrayList<>();

}