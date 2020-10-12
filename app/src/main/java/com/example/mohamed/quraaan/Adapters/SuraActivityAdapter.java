package com.example.mohamed.quraaan.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohamed.quraaan.Models.SuraActivityModel;
import com.example.mohamed.quraaan.R;

import java.util.List;

public class SuraActivityAdapter  extends RecyclerView.Adapter<SuraActivityAdapter.viewHolder>{


    List<SuraActivityModel>items;

    onItemClickListner OnAyaClickListener;
    public SuraActivityAdapter(List<SuraActivityModel> items) {
        this.items = items;
    }

    public void setOnAyaClickListener(onItemClickListner onAyaClickListener) {
        OnAyaClickListener = onAyaClickListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sura_activity_item,viewGroup,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder viewHolder, final int i) {

        final SuraActivityModel suraActivityModel=items.get(i);
        viewHolder.text.setText(suraActivityModel.getText());
        if (OnAyaClickListener!=null){

            viewHolder.text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // viewHolder.itemView.setBackgroundResource(R.drawable.item_background);
                    OnAyaClickListener.onItemClick(i,suraActivityModel);

                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {



        TextView text;



        public viewHolder(@NonNull View v) {
            super(v);
            text=v.findViewById(R.id.text_sura_acticity_item);



        }
    }
    public interface onItemClickListner {
        void onItemClick(int pos,SuraActivityModel aya);
    }


}
