package com.example.monitoringexport.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelProforma {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Proforma mProforma;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Proforma getmProforma() {
        return mProforma;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setmProforma(Proforma mProforma) {
        this.mProforma = mProforma;
    }
}
