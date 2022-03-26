package com.portfolio.api.Portfolio.persistence.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AssetDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String assetName;

    private Long unitPrice;

    private Long remQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getRemQuantity() {
        return remQuantity;
    }

    public void setRemQuantity(Long remQuantity) {
        this.remQuantity = remQuantity;
    }
}
