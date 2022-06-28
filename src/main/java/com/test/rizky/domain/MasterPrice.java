package com.test.rizky.domain;

import com.google.gson.Gson;
import com.test.rizky.shared.LongIdentityEntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "master_price")
@Entity
@Getter
@Setter
public class MasterPrice extends LongIdentityEntityBase {
    private static final long serialVersionUID = -9012155658302171102L;
    private String originCode;
    private String destinationCode;
    private double price;
    private String product;


    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
