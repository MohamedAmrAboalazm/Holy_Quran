package com.example.mohamed.quraaan.API;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohamed.quraaan.API.Model.RecitersItem;
import com.example.mohamed.quraaan.R;

import java.util.List;

public class Reciters_adapter extends RecyclerView.Adapter<Reciters_adapter.ViewHolder>{


    List<RecitersItem> items;
    onItemClickListner onPlayClickListener;

    public void setOnPlayClickListener(onItemClickListner onPlayClickListener) {
        this.onPlayClickListener = onPlayClickListener;
    }

    public Reciters_adapter(List<RecitersItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.reciters_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
final RecitersItem reciter=items.get(position);
      viewHolder.ReciterName.setText(reciter.getName());
      viewHolder.ReciterRewaya.setText(reciter.getRewaya());
      if(onPlayClickListener!=null){
          viewHolder.play.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  onPlayClickListener.onItemClick(position,reciter);
              }
          });
      }
    }

    public void changeData(List<RecitersItem>items){
        this.items=items;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if (items==null) return 0;

        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView ReciterName;
        TextView ReciterRewaya;
        ImageView play;


        public ViewHolder(View view) {
            super(view);
ReciterName=view.findViewById(R.id.text_reciter_name_item);
ReciterRewaya=view.findViewById(R.id.text_reciter_rewaya_item);
play=view.findViewById(R.id.play_aya);
        }
    }
    public interface onItemClickListner {
        void onItemClick(int pos, RecitersItem Reciter);
    }
}