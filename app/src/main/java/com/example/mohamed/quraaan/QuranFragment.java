package com.example.mohamed.quraaan;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.mohamed.quraaan.Adapters.QuranGridAdapter;
import com.example.mohamed.quraaan.Models.Sura;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuranFragment extends Fragment {

    RecyclerView quranRecyclrView;
    QuranGridAdapter quranGridAdapter;
    GridLayoutManager gridLayoutManager;
    List<Sura> data;

    public static  String []ArSuras={"الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام","الأعراف","الأنفال","التوبة","يونس","هود"
            ,"يوسف","الرعد","إبراهيم","الحجر","النحل","الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون"
            ,"النّور","الفرقان","الشعراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
            ,"فاطر","يس","الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف"
            ,"محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة","الحديد","المجادلة"
            ,"الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق","التحريم","الملك","القلم","الحاقة","المعارج"
            ,"نوح","الجن","المزّمّل","المدّثر","القيامة","الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار"
            ,"المطفّفين","الإنشقاق","البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس","الليل","الضحى","الشرح"
            ,"التين","العلق","القدر","البينة","الزلزلة","العاديات","القارعة","التكاثر","العصر",
            "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون","النصر","المسد","الإخلاص","الفلق","الناس"};


    int position=0;

    View view;

    public QuranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_quran, container, false);

        CreateQuranGrid();
        quranRecyclrView=view.findViewById(R.id.recycler_view_grid);
        gridLayoutManager=new GridLayoutManager(getActivity(),3,GridLayout.HORIZONTAL,false);
        SnapHelper snapHelper=new LinearSnapHelper();

        snapHelper.attachToRecyclerView(quranRecyclrView);



        quranGridAdapter=new com.example.mohamed.quraaan.Adapters.QuranGridAdapter(data);
        quranGridAdapter.setOnTextClick(new com.example.mohamed.quraaan.Adapters.QuranGridAdapter.onIteamClickLisnear() {
            @Override
            public void onIteamClick(int pos, Sura swar) {
                Intent intent=new Intent(getActivity(),SuraActivity.class);
                intent.putExtra("pos",pos);
                intent.putExtra("sura_name",ArSuras[pos]);
                startActivity(intent);

            }
        });

        quranRecyclrView.setAdapter(quranGridAdapter);
        quranRecyclrView.setLayoutManager(gridLayoutManager);

        return view;
    }

    public void CreateQuranGrid()
    {


        data=new ArrayList<>();
        for(int i=0;i<ArSuras.length;i++)
        {

            data.add(new Sura(ArSuras[i]));
        }
    }
}
