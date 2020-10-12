package com.example.mohamed.quraaan.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohamed.quraaan.Models.AhadesModel;
import com.example.mohamed.quraaan.R;

import java.util.List;

public class    AhadesVerticalAdapter extends RecyclerView.Adapter<AhadesVerticalAdapter.viewHolder>{

    List<AhadesModel> Iteams;

    AhadesVerticalAdapter.onIteamClickLisnear onItemClick;

    public void setOnTextClick(AhadesVerticalAdapter.onIteamClickLisnear onTextClick) {
        this.onItemClick = onTextClick;
    }
    public AhadesVerticalAdapter(List<AhadesModel> iteams) {
        Iteams = iteams;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int postion) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.ahades_item,parent,false);

        return new AhadesVerticalAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder parent, final int postion) {

        final AhadesModel ahdes=Iteams.get(postion);

        parent.namesAhades.setText(ahdes.getNameAhades());
        if (onItemClick!=null){

            parent.namesAhades.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick.onIteamClick(postion,ahdes);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(Iteams==null)return 0;
        return Iteams.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {



        TextView namesAhades;

        public viewHolder(@NonNull View v) {
            super(v);


            namesAhades=v.findViewById(R.id.txt_ahades_item);
        }
    }

    public  interface onIteamClickLisnear{


        void onIteamClick(int pos, AhadesModel ahadesModel);

    }
}
