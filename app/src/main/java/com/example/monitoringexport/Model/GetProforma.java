package com.example.monitoringexport.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetProforma {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Proforma> listDataProforma;
    @SerializedName("message")
    String message;

    public  String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Proforma> getListDataProforma() {
        return listDataProforma;
    }

    public void setListDataProforma(List<Proforma> listDataProforma) {
        this.listDataProforma = listDataProforma;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
