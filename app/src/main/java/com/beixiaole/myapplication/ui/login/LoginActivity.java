package com.beixiaole.myapplication.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.beixiaole.myapplication.R;
import com.beixiaole.myapplication.data.model.LoggedInUser;
import com.beixiaole.myapplication.service.LoginService;
import com.beixiaole.myapplication.ui.home.HomeActivity;
import com.beixiaole.myapplication.ui.register.RegisterActivity;


public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText userpassword;
    private Button login;
    private Button register;
    private SharedPreferences sp;
    private String userNameValue, passwordValue;
    private TextView login_error;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化各变量
        username = findViewById(R.id.username);
        userpassword = findViewById(R.id.password);
        login = findViewById(R.id.bt_login);
        register = findViewById(R.id.bt_register);
        login_error = findViewById(R.id.login_error);

        sp = getSharedPreferences("userInfo", 0);
//        String name = sp.getString("USER_NAME","");
//        String pass = sp.getString("PASSWORD","");
        String login_config = sp.getString("LOGIN_CONFIG", "");
        //判断是否登录过。login_config用于判断登录与退出
        if (login_config.equals("true")) {
//            username.setText(name);
//            userpassword.setText(pass);
            //跳转主页
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);

//            LoginActivity.this.onDestroy();
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //验证登录
                userNameValue = username.getText().toString();
                passwordValue = userpassword.getText().toString();
                SharedPreferences.Editor editor = sp.edit();  //编辑权限

                LoggedInUser user = new LoggedInUser(userNameValue, passwordValue);
                if (new LoginService().loginConfirm(user)) {
                    //保存用户名和密码
                    editor.putString("USER_NAME", userNameValue);
                    editor.putString("PASSWORD", passwordValue);
                    editor.putString("LOGIN_CONFIG", "true");
                    editor.commit();

                    //跳转主页
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);

//                    LoginActivity.this.onDestroy();
                    finish();
                } else {
                    login_error.setText("账号或者密码错误！");
                }


            }
        });
        //注册按钮跳转
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
