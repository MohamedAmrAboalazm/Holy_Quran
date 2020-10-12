package com.example.mohamed.quraaan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ElsebhaFragment extends Fragment{

    int Counter=0;
    int resett=0;

    Button btn;
    Button total;
    ImageView reset;
    ImageView sebha;
    public ElsebhaFragment() {
        // Required empty public constructor
    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_elsebha, container, false);

        sebha=view.findViewById(R.id.image_sebhaa);
        btn=view.findViewById(R.id.btnNumOfClicks);
        total=view.findViewById(R.id.btn_total);
        reset=view.findViewById(R.id.image_tasfer);

        sebha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Counter++;
                btn.setText(Integer.toString(Counter));
                total.setText(btn.getText());


            }

        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter=0;
                btn.setText(Integer.toString(resett));
                total.setText(btn.getText());


            }
        });

        return view;
    }

}
