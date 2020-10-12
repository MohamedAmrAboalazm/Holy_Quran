package com.example.mohamed.quraaan;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohamed.quraaan.APIs.ApiManager;
import com.example.mohamed.quraaan.APIs.ModelRadioChannel.RadiosItem;
import com.example.mohamed.quraaan.APIs.ModelRadioChannel.RadiosResponse;
import com.example.mohamed.quraaan.Adapters.RadiosAdapter;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends Fragment {


    RecyclerView RadioRecyclerview;
    RadiosAdapter radiosAdapter;
    RecyclerView.LayoutManager layoutManager;


    public RadioFragment() {
        // Required empty public constructor
    }

View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_radio, container, false);
        RadioRecyclerview=view.findViewById(R.id.radios_recycler_view);
        layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        radiosAdapter=  new RadiosAdapter(null);
         RadioRecyclerview.setLayoutManager(layoutManager);
         RadioRecyclerview.setAdapter(radiosAdapter);

         radiosAdapter.setOnPlayClick(new RadiosAdapter.onIteamClickLisnear() {
             @Override
             public void onIteamClick(int pos, RadiosItem radiosItem) {

                 PlayChannel(radiosItem.getURL());
             }
         });

         radiosAdapter.setOnStopClick(new RadiosAdapter.onIteamClickLisnear() {
    @Override
    public void onIteamClick(int pos, RadiosItem radiosItem) {

        StopPlaying();
    }
});

        getRadioChannels();

        return view;
    }

    MediaPlayer mediaPlayer;
    public void PlayChannel(String URL){

        StopPlaying();
        mediaPlayer=new MediaPlayer();
        try {
            mediaPlayer.setDataSource(URL);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void StopPlaying(){


        if(mediaPlayer!=null)
            mediaPlayer.stop();
    }

    void getRadioChannels(){

       // showProgressBar();
        ApiManager.getApis()
                .getAllRadioChannels()
                .enqueue(new Callback<RadiosResponse>() {
                    @Override
                    public void onResponse(Call<RadiosResponse> call, Response<RadiosResponse> response) {

                       // hideProgressBar();
                        if(response.isSuccessful()){

                            radiosAdapter.changeData(response.body().getRadios());
                        }
                    }

                    @Override
                    public void onFailure(Call<RadiosResponse> call, Throwable t) {

                        //hideProgressBar();
                       // showMessage("Error",t.getLocalizedMessage(),"OK");
                    }
                });

    }

}
