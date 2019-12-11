package com.beixiaole.myapplication.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.beixiaole.myapplication.ui.community.CommunityActivity;
import com.beixiaole.myapplication.ui.login.LoginActivity;
import com.beixiaole.myapplication.ui.personal.PersonActivity;
import com.beixiaole.myapplication.ui.plan.PlanActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import com.beixiaole.myapplication.R;

public class HomeActivity extends AppCompatActivity {
    private  Button home;
    private Button comm;
    private Button paln;
    private Button person;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home = findViewById(R.id.rd_menu_home);
        comm = findViewById(R.id.rd_menu_community);
        paln = findViewById(R.id.rd_menu_plan);
        person = findViewById(R.id.rd_menu_person);

//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
//                startActivity(intent);
//            }
//        });
        comm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CommunityActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);//去掉Activity切换间的动画
            }
        });
        paln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PlanActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);//去掉Activity切换间的动画
            }
        });
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PersonActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);//去掉Activity切换间的动画
            }
        });




    }

}
