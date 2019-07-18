package com.example.monitoringexport.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetUser {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<User> listDataUser;
    @SerializedName("message")
    String message;
    public  String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getListDataUser() {
        return listDataUser;
    }

    public void setListDataUser(List<User> listDataUser) {
        this.listDataUser = listDataUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
