package com.vehicle.workshop.enums;

public enum PartCategory {

    FM("FAST MOVING"),
    OT("OTHER"),
    SM("SLOW MOVING"),
    DS("DEAD STOCK"),
    BS("BODY SHOP"),
    PM("PAINT"),
    CI("CONSUMABLE ITEMS"),
    NA("NOT ACTIVE");

    private String partCategory;

    PartCategory(String partCategory) {
        this.partCategory = partCategory;
    }

    public String getPartCategory() {
        return partCategory;
    }
}
