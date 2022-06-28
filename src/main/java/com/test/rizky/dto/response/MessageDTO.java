package com.test.rizky.dto.response;

import com.google.gson.Gson;

import java.io.Serializable;

public class MessageDTO implements Serializable {
    private String IN;
    private String EN;

    public String getIN() {
        return IN;
    }

    public void setIN(String IN) {
        this.IN = IN;
    }

    public String getEN() {
        return EN;
    }

    public void setEN(String EN) {
        this.EN = EN;
    }

    @Override
    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
