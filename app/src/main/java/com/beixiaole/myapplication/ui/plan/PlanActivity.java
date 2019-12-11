package com.beixiaole.myapplication.ui.plan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.beixiaole.myapplication.R;
import com.beixiaole.myapplication.ui.community.CommunityActivity;
import com.beixiaole.myapplication.ui.home.HomeActivity;
import com.beixiaole.myapplication.ui.personal.PersonActivity;

public class PlanActivity extends AppCompatActivity {
    private Button home;
    private Button comm;
    private Button paln;
    private Button person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);


        home = findViewById(R.id.rd_menu_home);
        comm = findViewById(R.id.rd_menu_community);
        paln = findViewById(R.id.rd_menu_plan);
        person = findViewById(R.id.rd_menu_person);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);//去掉Activity切换间的动画
            }
        });
        comm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, CommunityActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);//去掉Activity切换间的动画
            }
        });
//        paln.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, PlanActivity.class);
//                startActivity(intent);
//            }
//        });
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, PersonActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);//去掉Activity切换间的动画
            }
        });
    }
}
