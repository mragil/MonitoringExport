package com.example.monitoringexport.Rest;

import com.example.monitoringexport.Model.GetUser;
import com.example.monitoringexport.Model.PostPutDelProforma;
import com.example.monitoringexport.Model.PostPutDelUser;
import com.example.monitoringexport.Model.Proforma;
import com.example.monitoringexport.Model.User;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {
    @Headers({
            "x-access-token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwiaWF0IjoxNTYzNDIwNDAzLCJleHAiOjE1NjM1MDY4MDN9.YehndIhtkEt1yceKMW1wMUTRxLWT83Bnf4MxL7aHdV8"
    })
    @GET("proforma/")
    Call<List<Proforma>> getProforma();
    @GET("users/")
    Call<List<User>> getUser();
    @FormUrlEncoded
    @POST("users/")
    Call<PostPutDelUser> postUser (@Field("nama") String nama,
                                    @Field("email") String email,
                                    @Field("password") String password,
                                    @Field("level") String level);
    @FormUrlEncoded
    @POST("proforma/")
    Call<Void> postProforma(@Field("nama_produk") String nama_produk,
                                          @Field("tanggal_peb") String tanggal_peb,
                                          @Field("pembuat") String pembuat);


}
