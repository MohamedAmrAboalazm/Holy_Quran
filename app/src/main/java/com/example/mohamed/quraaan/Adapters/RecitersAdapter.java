package com.example.mohamed.quraaan.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohamed.quraaan.APIs.Model.NamesResponse;
import com.example.mohamed.quraaan.APIs.Model.RecitersItem;
import com.example.mohamed.quraaan.R;

import java.util.List;

public class RecitersAdapter extends RecyclerView.Adapter<RecitersAdapter.viewHolder>{

    List<RecitersItem> Channels;


    public RecitersAdapter(List<RecitersItem> channels) {
        Channels = channels;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int postion) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.shiekh_names_item,parent,false);

        return new RecitersAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder parent, final int postion) {

        final RecitersItem reciter=Channels.get(postion);
        parent.names.setText(reciter.getName());
        parent.rewaya.setText(reciter.getRewaya());

        }


   public void changeData(List<RecitersItem>items){
        this.Channels=items;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(Channels==null)return 0;
        return Channels.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {



        TextView names;
        TextView rewaya;

        public viewHolder(@NonNull View v) {
            super(v);


            names=v.findViewById(R.id.nameShikh);
            rewaya=v.findViewById(R.id.rewaya);
        }
    }

    public RecitersItem getItemAtPostion(int pos){

        return Channels.get(pos);

    }
    public  interface onIteamClickLisnear{


        void onIteamClick(int pos, NamesResponse namesResponse);

    }
}
