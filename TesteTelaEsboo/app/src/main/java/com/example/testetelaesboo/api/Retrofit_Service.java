package com.example.testetelaesboo.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Service {
    private final   Retrofit retrofit;


    public  Retrofit_Service(){
                this.retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.31:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



    }

    public Sara_Api getSaraApi() {
        return (Sara_Api) this.retrofit.create(Sara_Api.class);
    }


}
