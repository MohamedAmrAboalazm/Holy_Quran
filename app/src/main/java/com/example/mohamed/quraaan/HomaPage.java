package com.example.mohamed.quraaan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.mohamed.quraaan.Base.BaseActivity;


public class HomaPage extends BaseActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id=item.getItemId();
            Fragment fragment=null;
            if(id==R.id.navigation_quran){

                fragment=new QuranFragment();

            }else if(id==R.id.navigation_sebha){

                fragment=new ElsebhaFragment();
            }else if(id==R.id.navigation_ahades){
                fragment=new AhadesFragment();
            }else if(id==R.id.navigation_radio){
                fragment=new RadioFragment();
            }else if(id==R.id.navigation_audio){
                fragment=new QuranAudioFragment();
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout_Continer,fragment).commit();

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homa_page);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_quran);
    }



    @Override
    public void onBackPressed() {


        showConfirmationMessage(R.string.Warning, R.string.do_u_want_exit, R.string.yes, new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialog.dismiss();
                finish();

            }
        });

    }
}
