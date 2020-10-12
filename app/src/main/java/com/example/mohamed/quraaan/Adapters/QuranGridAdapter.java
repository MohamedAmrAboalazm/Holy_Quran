package com.example.mohamed.quraaan.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohamed.quraaan.Models.Sura;
import com.example.mohamed.quraaan.R;

import java.util.List;

public class QuranGridAdapter extends RecyclerView.Adapter<QuranGridAdapter.viewHolder> {

    List<Sura>Iteams;

    onIteamClickLisnear onTextClick;

    public void setOnTextClick(onIteamClickLisnear onTextClick) {
        this.onTextClick = onTextClick;
    }

    public QuranGridAdapter(List<Sura> iteams) {
        Iteams = iteams;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.quran_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuranGridAdapter.viewHolder parent, final int postion) {

        final Sura quran=Iteams.get(postion);

        parent.NamesQuran.setText(quran.getNamesQuran());
        if (onTextClick!=null){

            parent.NamesQuran.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onTextClick.onIteamClick(postion,quran);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return Iteams.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {



        TextView NamesQuran;

        public viewHolder(@NonNull View v) {
            super(v);


            NamesQuran=v.findViewById(R.id.NamesQuraan);
        }
    }

    public  interface onIteamClickLisnear{


        void onIteamClick(int pos,Sura swar);

    }
}
