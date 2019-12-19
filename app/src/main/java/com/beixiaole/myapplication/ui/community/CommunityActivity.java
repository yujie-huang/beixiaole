package com.beixiaole.myapplication.ui.community;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.beixiaole.myapplication.R;
import com.beixiaole.myapplication.ui.home.HomeActivity;
import com.beixiaole.myapplication.ui.personal.PersonActivity;
import com.beixiaole.myapplication.ui.plan.PlanActivity;

public class CommunityActivity extends AppCompatActivity {
    private Button home;
    private Button comm;
    private Button paln;
    private Button person;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        home = findViewById(R.id.rd_menu_home);
        comm = findViewById(R.id.rd_menu_community);
        paln = findViewById(R.id.rd_menu_plan);
        person = findViewById(R.id.rd_menu_person);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( CommunityActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);//去掉Activity切换间的动画
            }
        });
//        comm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, CommunityActivity.class);
//                startActivity(intent);
//            }
//        });
        paln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( CommunityActivity.this, PlanActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);//去掉Activity切换间的动画
            }
        });
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( CommunityActivity.this, PersonActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);//去掉Activity切换间的动画
            }
        });
    }
}
