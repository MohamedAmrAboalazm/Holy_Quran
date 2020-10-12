package com.example.mohamed.quraaan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mohamed.quraaan.Adapters.SuraActivityAdapter;
import com.example.mohamed.quraaan.Models.SuraActivityModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AhadesActivity extends AppCompatActivity {

    RecyclerView recyclerViewAhadesActivity;
    SuraActivityAdapter suraActivityAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<SuraActivityModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahades);

        reading();

         recyclerViewAhadesActivity=findViewById(R.id.recyclerview_ahades_activity);
        layoutManager=new LinearLayoutManager(AhadesActivity.this);
        suraActivityAdapter=new SuraActivityAdapter(data);
        recyclerViewAhadesActivity.setAdapter(suraActivityAdapter);
        recyclerViewAhadesActivity.setLayoutManager(layoutManager);
    }


    public void reading(){

        data=new ArrayList<>();

        Bundle pos = getIntent().getExtras();
        int id =pos.getInt("key");
        //String key=pos.getString("sura_name");




       // TextView ahdesActivity=(TextView) findViewById(R.id.content_ahades);


        BufferedReader reader;

        try{
            final InputStream file = getAssets().open("h"+(id+1)+".txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while(line != null){


                data.add(new SuraActivityModel(line));
                //data.add(new SuraActivityModel(line));

                line = reader.readLine();
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
       // ahdesActivity.setText(id);


    }
}
