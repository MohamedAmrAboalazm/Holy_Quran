package com.example.mohamed.quraaan;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohamed.quraaan.Adapters.AhadesVerticalAdapter;
import com.example.mohamed.quraaan.Models.AhadesModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AhadesFragment extends Fragment {

    RecyclerView ahadesRecyclrView;
    AhadesVerticalAdapter ahadesVerticalAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<AhadesModel> data;
    View view;

    public AhadesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_ahades, container, false);

        CreateAhades();
        ahadesRecyclrView=view.findViewById(R.id.recycler_view_ahades);
        layoutManager=new LinearLayoutManager(getActivity());

        ahadesVerticalAdapter=new AhadesVerticalAdapter(data);

        ahadesVerticalAdapter.setOnTextClick(new AhadesVerticalAdapter.onIteamClickLisnear() {
            @Override
            public void onIteamClick(int pos, AhadesModel ahadesModel) {


                Intent intent=new Intent(getActivity(),AhadesActivity.class);
                intent.putExtra("key",pos);
                startActivity(intent);

            }
        });

        ahadesRecyclrView.setAdapter(ahadesVerticalAdapter);
        ahadesRecyclrView.setLayoutManager(layoutManager);

        return view;
    }

    public void CreateAhades()
    {


        data=new ArrayList<>();
        for( int i=1;i<52;i++)
        {

            data.add(new AhadesModel("الحديث رقم "+i));
        }
    }
}
