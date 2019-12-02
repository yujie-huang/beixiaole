package com.beixiaole.myapplication.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.beixiaole.myapplication.R;
import com.beixiaole.myapplication.service.RegisterService;

import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Timer;

public class RegisterActivity extends AppCompatActivity {
    private EditText userName;
    private EditText identifying_code;
    private EditText password;
    private Button get_code;
    private Button register;
    private TextView code_time;
    private String service_code;

    private String user_code;
    private String username;
    private String userpassword;
    private SharedPreferences sp;
    private TextView error;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userName = findViewById(R.id.register_userName);
        password = findViewById(R.id.register_password);
        identifying_code = findViewById(R.id.register_yanzhengma);
        get_code = findViewById(R.id.bt_register_yanzhengma);
        register = findViewById(R.id.bt_register);
        code_time = findViewById(R.id.register_daojishi);
        error = findViewById(R.id.register_error);
        sp = getSharedPreferences("userInfo", 0);


        get_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //两个&&，前面true才执行后面
                if ((!userName.getText().toString().equals("")) && isMobileNO(userName.getText().toString())) {

                    service_code = new RegisterService().getCodeByPhone(userName.getText().toString());

                    get_code.setEnabled(false);
                    error.setText("已发送验证码！");
                    //点击一次，开始倒计时
//                        Timer timer = new Timer();
//                        timer.schedule(new TimerTask() {
//                            long midTime = 120000;
//                            public void run() {
//                                midTime--;
//                                long ss=midTime/1000;
//                                code_time.setText(ss+"秒后重新发送");
//                            }
//                        },0,120000);
                    get_code.setEnabled(true);
                    register.setEnabled(true);
                } else {
                    error.setText("请输入正确手机号！");
                }


            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(userName.getText().toString().equals("") && identifying_code.getText().toString().equals("") && password.getText().toString().equals(""))) {
//                    error.setText("注册失败，请检查验证码或手机号！");  ////这是一个测试
                    user_code = identifying_code.getText().toString();
                    username = userName.getText().toString();
                    userpassword = password.getText().toString();
                    SharedPreferences.Editor editor = sp.edit();  //编辑权限
                    RegisterService res = new RegisterService();
                    if (res.registerCommit(username, userpassword) && service_code.equals(user_code)) {
//                        跳转到资料更新添加页，并添加本地保存
                        editor.putString("USER_NAME", username);
                        editor.putString("PASSWORD", userpassword);
                        editor.putString("LOGIN_CONFIG", "true");
                        editor.commit();
                        Intent intent = new Intent(RegisterActivity.this, UserInfoUpdateActivity.class);
                        startActivity(intent);
                        finish();
                    } else
                        error.setText("注册失败，请检查验证码或手机号！");
                } else {
                    error.setText("不能为空！");
                }
            }
        });


    }

    //手机号验证函数
    public boolean isMobileNO(String mobiles) {

        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(14[5,7])| (17[0,1,3,5-8]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
