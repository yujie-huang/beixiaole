package com.beixiaole.myapplication.ui.personal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.beixiaole.myapplication.R;
import com.beixiaole.myapplication.ui.home.HomeActivity;
import com.beixiaole.myapplication.ui.login.LoginActivity;

public class PersonActivity extends AppCompatActivity {
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
    }
}
