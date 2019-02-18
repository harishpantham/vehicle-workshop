package com.vehicle.workshop.enums;

public enum TaxTypeEnum {

    SGST("GST 28%"),
    CGST("GST 28%");

    private String taxType;

    TaxTypeEnum(String partCategory) {
        this.taxType = taxType;
    }

    public String getPartCategory() {
        return taxType;
    }
}
