package com.example.monitoringexport.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://192.168.43.239:3000/";
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = builder.build();
    //Service builder that creates implementation of those interfaces is created here.
    public static <T> T buildService(Class<T> type) {
        return retrofit.create(type);
    }
}

