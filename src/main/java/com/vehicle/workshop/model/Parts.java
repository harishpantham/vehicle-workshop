package com.vehicle.workshop.model;

import com.vehicle.workshop.enums.PartCategory;
import com.vehicle.workshop.enums.TaxTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Parts extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private PartCategory partCategory;

    private String partGroup;

    private String partMaker;

    private String otherMakersName;

    @NotNull
    private String name;

    private String UOM;

    private String HSNCode;

    private Long packing;

    @Enumerated(EnumType.STRING)
    private TaxTypeEnum taxTypeEnum;

    private Float taxPercentage;

    private Float surChargePercentage;

    private Double mrp;

    private Double saleRate;

    private Double purchaseRate;

    private int itemExpiryDays;

    private Double maxOrderLevel;

    private Double minOrderLevel;

    private String billNumber;

    @Column(columnDefinition = "TEXT")
    private String remarks;

    private Long currentStock;

    private Boolean isActive = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service service;

    public PartCategory getPartCategory() {
        return partCategory;
    }

    public void setPartCategory(PartCategory partCategory) {
        this.partCategory = partCategory;
    }

    public String getPartGroup() {
        return partGroup;
    }

    public void setPartGroup(String partGroup) {
        this.partGroup = partGroup;
    }

    public String getPartMaker() {
        return partMaker;
    }

    public void setPartMaker(String partMaker) {
        this.partMaker = partMaker;
    }

    public String getOtherMakersName() {
        return otherMakersName;
    }

    public void setOtherMakersName(String otherMakersName) {
        this.otherMakersName = otherMakersName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUOM() {
        return UOM;
    }

    public void setUOM(String UOM) {
        this.UOM = UOM;
    }

    public String getHSNCode() {
        return HSNCode;
    }

    public void setHSNCode(String HSNCode) {
        this.HSNCode = HSNCode;
    }

    public Long getPacking() {
        return packing;
    }

    public void setPacking(Long packing) {
        this.packing = packing;
    }

    public TaxTypeEnum getTaxTypeEnum() {
        return taxTypeEnum;
    }

    public void setTaxTypeEnum(TaxTypeEnum taxTypeEnum) {
        this.taxTypeEnum = taxTypeEnum;
    }

    public Float getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Float taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public Float getSurChargePercentage() {
        return surChargePercentage;
    }

    public void setSurChargePercentage(Float surChargePercentage) {
        this.surChargePercentage = surChargePercentage;
    }

    public Double getMrp() {
        return mrp;
    }

    public void setMrp(Double mrp) {
        this.mrp = mrp;
    }

    public Double getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(Double saleRate) {
        this.saleRate = saleRate;
    }

    public Double getPurchaseRate() {
        return purchaseRate;
    }

    public void setPurchaseRate(Double purchaseRate) {
        this.purchaseRate = purchaseRate;
    }

    public int getItemExpiryDays() {
        return itemExpiryDays;
    }

    public void setItemExpiryDays(int itemExpiryDays) {
        this.itemExpiryDays = itemExpiryDays;
    }

    public Double getMaxOrderLevel() {
        return maxOrderLevel;
    }

    public void setMaxOrderLevel(Double maxOrderLevel) {
        this.maxOrderLevel = maxOrderLevel;
    }

    public Double getMinOrderLevel() {
        return minOrderLevel;
    }

    public void setMinOrderLevel(Double minOrderLevel) {
        this.minOrderLevel = minOrderLevel;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Long currentStock) {
        this.currentStock = currentStock;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
