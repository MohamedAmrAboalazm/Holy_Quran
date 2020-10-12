package com.example.mohamed.quraaan;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.mohamed.quraaan.APIs.ApiManager;
import com.example.mohamed.quraaan.APIs.Model.NamesResponse;
import com.example.mohamed.quraaan.APIs.Model.RecitersItem;
import com.example.mohamed.quraaan.Adapters.RecitersAdapter;
import com.example.mohamed.quraaan.Adapters.SpinnerAdapter;
import com.example.mohamed.quraaan.Base.BaseFragment;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuranAudioFragment extends BaseFragment {

    RecyclerView recitersRecyclerView;
    RecitersAdapter adapter;
    Spinner spinner;
    RecyclerView.LayoutManager layoutManager;
    View view;
    ArrayList<Integer>SuresIndses;
    MediaPlayer mediaPlayer;

    public QuranAudioFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_quran_aduio, container, false);
        recitersRecyclerView = view.findViewById(R.id.reciters_recycler_view);
        spinner =view.findViewById(R.id.spinner);
        getAllReciters();
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new RecitersAdapter(null);
        recitersRecyclerView.setAdapter(adapter);
        recitersRecyclerView.setLayoutManager(layoutManager);
        SnapHelper snapHelper=new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recitersRecyclerView);



        recitersRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int firstvisiblepostion=((LinearLayoutManager)layoutManager).findFirstVisibleItemPosition();
                RecitersItem item=adapter.getItemAtPostion(firstvisiblepostion);
                setSpinnerData(item);




            }
        });

        return view;
    }

    public void setSpinnerData(RecitersItem item){


        String allSuresIndses=item.getSuras();
        String []arr=allSuresIndses.split(",");

        SuresIndses=new ArrayList<>();

        for(String s : arr){

            SuresIndses.add(Integer.valueOf(s)-1);
        }

        ArrayList<String>names=new ArrayList<>();
        for(int i=0;i<SuresIndses.size();i++){
            int index =SuresIndses.get(i);
            String name =QuranFragment.ArSuras[index];
            names.add(name);

        }

        SpinnerAdapter spinnerAdapter=new SpinnerAdapter(names);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                int suraindex=SuresIndses.get(position);
                String suraIndexString=(suraindex+1)+"";
                while (suraIndexString.length()<3)suraIndexString="0"+suraIndexString;

                int firstvisiblepostion=((LinearLayoutManager)layoutManager)
                        .findFirstVisibleItemPosition();
                RecitersItem recitersItem=adapter.getItemAtPostion(firstvisiblepostion);
                String URL=recitersItem.getServer()+"/"+suraIndexString+".mp3";
                PlayChannel(URL);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                StopPlaying();
            }
        });
    }



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

    void getAllReciters(){

        showProgressBar();
        ApiManager.getApis().getAllRadioReciters().enqueue(new Callback<NamesResponse>() {
            @Override
            public void onResponse(Call<NamesResponse> call, Response<NamesResponse> response) {

                hideProgressBar();
                if(response.isSuccessful()){
                    adapter.changeData(response.body().getReciters());

                }
            }

            @Override
            public void onFailure(Call<NamesResponse> call, Throwable t) {

                hideProgressBar();
                showMessage("Error",t.getLocalizedMessage(),"OK");
            }
        });



    }



}