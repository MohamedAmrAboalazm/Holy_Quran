package com.example.mohamed.quraaan.API;

import com.example.mohamed.quraaan.API.Model.RadiosResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCalls {
  //@GET("verse/verse.php")
  @GET("verse//radio_ar.json")
  Call<RadiosResponse> getAllReciters();

}
