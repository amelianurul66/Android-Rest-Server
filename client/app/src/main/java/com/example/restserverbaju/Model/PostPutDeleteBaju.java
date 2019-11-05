package com.example.restserverbaju.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDeleteBaju {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Baju mBaju;
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
    public Baju getBaju() {
        return mBaju;
    }
    public void setBaju(Baju Baju) {
        mBaju = Baju;
    }
}
