package com.example.monitoringexport.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Proforma {
    @SerializedName("id_data")
    private int idData;
    @SerializedName("nama_produk")
    private String namaProduk;
    @SerializedName("tanggal_peb")
    private Date tanggalPeb;
    @SerializedName("pembuat")
    private String pembuat;

    public Proforma(){}

    public Proforma(int idData, String namaProduk, Date tanggalPeb, String pembuat){
        this.idData = idData;
        this.namaProduk = namaProduk;
        this.tanggalPeb = tanggalPeb;
        this.pembuat = pembuat;
    }

    public int getIdData() {
        return idData;
    }

    public void setIdData(int idData) {
        this.idData = idData;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public Date getTanggalPeb() {
        return tanggalPeb;
    }

    public void setTanggalPeb(Date tanggalPeb) {
        this.tanggalPeb = tanggalPeb;
    }

    public String getPembuat() {
        return pembuat;
    }

    public void setPembuat(String pembuat) {
        this.pembuat = pembuat;
    }
}
