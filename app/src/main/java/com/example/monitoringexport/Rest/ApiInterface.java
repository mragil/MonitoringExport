package com.example.monitoringexport.Rest;

import com.example.monitoringexport.Model.GetUser;
import com.example.monitoringexport.Model.Login;
import com.example.monitoringexport.Model.PostPutDelProforma;
import com.example.monitoringexport.Model.PostPutDelUser;
import com.example.monitoringexport.Model.Proforma;
import com.example.monitoringexport.Model.Session;
import com.example.monitoringexport.Model.User;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("login/")
    Call<Session> login(@Body Login login);

    @GET("proforma/")
    Call<List<Proforma>> getProforma(@Header("Authorization") String token);
    @GET("users/")
    Call<List<User>> getUser(@Header("Authorization") String token);
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
