package com.manmohanp.offers.models;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Offer {

    @NotNull(message="Offer Id is mandatory")
    String id;
    @NotNull(message="Offer name is mandatory")
    String name;
    @NotNull(message="Offer detail is mandatory")
    String detail;
    @NotNull(message="Offer date is mandatory")
    Date validFrom;
    @NotNull(message="Offer date is mandatory")
    Date validTo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }
}
