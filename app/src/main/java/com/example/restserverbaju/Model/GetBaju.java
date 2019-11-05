package com.example.restserverbaju.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBaju {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Baju> listDataBaju;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Baju> getListDataBaju() {
        return listDataBaju;
    }
    public void setListDataBaju(List<Baju> listDataBaju) {
        this.listDataBaju = listDataBaju;
    }
}
