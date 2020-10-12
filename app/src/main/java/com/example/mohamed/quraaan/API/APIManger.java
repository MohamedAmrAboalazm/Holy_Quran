package com.example.mohamed.quraaan.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManger {
    private static Retrofit retrofitInstance;
    private static Retrofit getRetrofitInstance(){
        if(retrofitInstance==null){
            retrofitInstance=new Retrofit.Builder().baseUrl("http://www.mp3quran.net//api/").addConverterFactory(GsonConverterFactory.create()).build();
        }
return retrofitInstance;
    }
    public static ApiCalls getApis(){
        ApiCalls apiCalls=getRetrofitInstance().create(ApiCalls.class);
        return apiCalls;

    }
}
/*"https://mp3quran.net//api/"*/