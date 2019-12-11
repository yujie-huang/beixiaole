package com.beixiaole.myapplication.ui.personal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.beixiaole.myapplication.R;
import com.beixiaole.myapplication.ui.community.CommunityActivity;
import com.beixiaole.myapplication.ui.home.HomeActivity;
import com.beixiaole.myapplication.ui.login.LoginActivity;
import com.beixiaole.myapplication.ui.plan.PlanActivity;

public class PersonActivity extends AppCompatActivity {
    private  Button home;
    private Button comm;
    private Button paln;
    private Button person;
    private SharedPreferences sp;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        logout = findViewById(R.id.bt_logout);
        sp=getSharedPreferences("userInfo",0);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("LOGIN_CONFIG", "false");
                editor.commit();

                Intent intent = new Intent(PersonActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        home = findViewById(R.id.rd_menu_home);
        comm = findViewById(R.id.rd_menu_community);
        paln = findViewById(R.id.rd_menu_plan);
        person = findViewById(R.id.rd_menu_person);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);//去掉Activity切换间的动画
            }
        });
        comm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonActivity.this, CommunityActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);//去掉Activity切换间的动画
            }
        });
        paln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonActivity.this, PlanActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);//去掉Activity切换间的动画
            }
        });
//        person.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(PersonActivity.this, PersonActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
