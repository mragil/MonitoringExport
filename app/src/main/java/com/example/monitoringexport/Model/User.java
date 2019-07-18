package com.example.monitoringexport.Model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id_user")
    private int id_user;
    @SerializedName("nama")
    private String nama;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("level")
    private int level;

    public User(){}

    public User(int id_user, String nama, String email, String password){
        this.id_user = id_user;
        this.nama = nama;
        this.email = email;
        this.password = password;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
