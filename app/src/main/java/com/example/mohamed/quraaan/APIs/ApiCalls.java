package com.example.mohamed.quraaan.APIs;

import com.example.mohamed.quraaan.APIs.Model.NamesResponse;
import com.example.mohamed.quraaan.APIs.ModelRadioChannel.RadiosResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCalls {

    @GET("_arabic.json")
    Call<NamesResponse>getAllRadioReciters();

    @GET("radio//radio_ar.json")
    Call<RadiosResponse>getAllRadioChannels();


}
