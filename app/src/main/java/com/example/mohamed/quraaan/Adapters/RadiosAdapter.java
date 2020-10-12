package com.example.mohamed.quraaan.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohamed.quraaan.APIs.ModelRadioChannel.RadiosItem;
import com.example.mohamed.quraaan.R;

import java.util.List;

public class RadiosAdapter extends RecyclerView.Adapter<RadiosAdapter.viewHolder>{

    List<RadiosItem> Channels;

    onIteamClickLisnear onPlayClick;
    onIteamClickLisnear onStopClick;

    public void setOnPlayClick(onIteamClickLisnear onPlayClick) {
        this.onPlayClick = onPlayClick;
    }

    public void setOnStopClick(onIteamClickLisnear onStopClick) {
        this.onStopClick = onStopClick;
    }

    public RadiosAdapter(List<RadiosItem> channels) {
        Channels = channels;
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int postion) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_radio_channels,parent,false);

        return new RadiosAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder parent, final int postion) {

        final RadiosItem channel=Channels.get(postion);
        parent.names.setText(channel.getName());
        if(onPlayClick!=null){

            parent.play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onPlayClick.onIteamClick(postion,channel);
                }
            });
        }
        if(onStopClick!=null){

            parent.stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onPlayClick.onIteamClick(postion,channel);
                }
            });

        }


    }

    public void changeData(List<RadiosItem>items){
        this.Channels=items;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(Channels==null)
        {return 0;}
        return Channels.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {



        TextView names;
        ImageView play;
        ImageView stop;

        public viewHolder(@NonNull View v) {
            super(v);


            names=v.findViewById(R.id.radio);
            play=v.findViewById(R.id.play);
            stop=v.findViewById(R.id.stop);
        }
    }

    public  interface onIteamClickLisnear{


        void onIteamClick(int pos, RadiosItem channel);

    }
}
