package com.beixiaole.myapplication.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.beixiaole.myapplication.ui.login.LoginActivity;
import com.beixiaole.myapplication.ui.personal.PersonActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import com.beixiaole.myapplication.R;

public class HomeActivity extends AppCompatActivity {
    private Button person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        person = findViewById(R.id.rd_menu_person);
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PersonActivity.class);
                startActivity(intent);
            }
        });



    }

}
