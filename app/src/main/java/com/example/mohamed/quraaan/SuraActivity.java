package com.example.mohamed.quraaan;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.widget.TextView;

import com.example.mohamed.quraaan.API.APIManger;
import com.example.mohamed.quraaan.API.Model.RadiosResponse;
import com.example.mohamed.quraaan.API.Model.RecitersItem;
import com.example.mohamed.quraaan.API.Reciters_adapter;
import com.example.mohamed.quraaan.Adapters.SuraActivityAdapter;
import com.example.mohamed.quraaan.Models.SuraActivityModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuraActivity extends AppCompatActivity {
    int AyaPos=1;
    RecyclerView recyclerViewSuraActivity ,recylerViewReciters;
    SuraActivityAdapter suraActivityAdapter;
    Reciters_adapter reciters_adapter;
    RecyclerView.LayoutManager layoutManager,layoutManagerHorizintal;
    int counter =0;
    List<SuraActivityModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura);

        recyclerViewSuraActivity=findViewById(R.id.recyclerview_sura_activity);
        recylerViewReciters=findViewById(R.id.suraActivity_audio_recycler_view);
        reading();


        layoutManagerHorizintal=new LinearLayoutManager(SuraActivity.this,LinearLayoutManager.HORIZONTAL,false);
        reciters_adapter=new Reciters_adapter(null);
        recylerViewReciters.setAdapter(reciters_adapter);
        recylerViewReciters.setLayoutManager(layoutManagerHorizintal);
        SnapHelper snapHelper =new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recylerViewReciters);
        reciters_adapter.setOnPlayClickListener(new Reciters_adapter.onItemClickListner() {
            @Override
            public void onItemClick(int pos, RecitersItem Reciter) {
                Bundle position = getIntent().getExtras();
                int SuraPos =position.getInt("pos");

                String suraIdexString=(SuraPos+1)+"";
                while (suraIdexString.length()<3)
                    suraIdexString="0"+suraIdexString;
                String AyaIndexString=(AyaPos+1)+"";
                while ((AyaIndexString.length()<3))
                    AyaIndexString="0"+AyaIndexString;
//
                String Url=Reciter.getURL()+"/"+suraIdexString+""+AyaIndexString+".mp3";
                Log.e("URL",Url);
                playAya(Url);
            }
        });
        getReciters();


        layoutManager=new LinearLayoutManager(SuraActivity.this);
        suraActivityAdapter=new SuraActivityAdapter(data);
        recyclerViewSuraActivity.setAdapter(suraActivityAdapter);
        recyclerViewSuraActivity.setLayoutManager(layoutManager);
        suraActivityAdapter.setOnAyaClickListener(new SuraActivityAdapter.onItemClickListner() {
            @Override
            public void onItemClick(int pos, SuraActivityModel aya) {
                String s=pos+"";
                Log.e("position",s);
                AyaPos=pos;
            }
        });

    }
    MediaPlayer mediaPlayer;
    public void playAya(String URL){
        //mediaPlayer.stop();
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
        }
        catch (IOException e){

        }


    }
    void getReciters(){
        APIManger.getApis().getAllReciters().enqueue(new Callback<RadiosResponse>() {
            @Override
            public void onResponse(Call<RadiosResponse> call, Response<RadiosResponse> response) {
                if (response.isSuccessful()){
                    List<RecitersItem>Name=response.body().getRadios();
                    reciters_adapter.changeData(response.body().getRadios());
                    reciters_adapter=new Reciters_adapter(response.body().getRadios());
                }
            }

            @Override
            public void onFailure(Call<RadiosResponse> call, Throwable t) {

            }
        });

    }
    public void reading(){

        data=new ArrayList<>();

        Bundle pos = getIntent().getExtras();
        int id =pos.getInt("pos");
        String key=pos.getString("sura_name");
        TextView textView=(TextView) findViewById(R.id.sura_name);
        BufferedReader reader;

        try{
            final InputStream file = getAssets().open((id+1)+".txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while(line != null){
                counter++;
                data.add(new SuraActivityModel(line +"("+counter+")"));

                line = reader.readLine();
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        textView.setText(key);
   /* StringBuilder item=new StringBuilder();



    try {

        InputStream input =getAssets().open((id+1)+".txt");

        InputStreamReader isr=new InputStreamReader(input);
        BufferedReader br=new BufferedReader(isr);

        try {
            String Line;
            while ((Line=br.readLine())!=null)
            {

                counter++;
                item.append(Line);
                item.append("("+counter+")"+'\n');


            }
        }catch (IOException e)
        {

        }


    } catch (IOException ex) {
        ex.printStackTrace();

    }
    textView.setText(item);*/


    }


}

