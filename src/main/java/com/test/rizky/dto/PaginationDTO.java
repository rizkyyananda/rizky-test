package com.test.rizky.dto;

import com.google.gson.Gson;

import java.io.Serializable;

public class PaginationDTO implements Serializable {
    private String originCode;


    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    @Override
    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
