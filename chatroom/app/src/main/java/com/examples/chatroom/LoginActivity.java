package com.examples.chatroom;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        //登录按钮
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击事件，匹配用户名和密码，跳转到聊天界面
                String userName = findViewById(R.id.username).getContext().toString();
                String passWord = findViewById(R.id.password).getContext().toString();
                Log.d("userName",userName);
                Log.d("passWord",passWord);
                Intent intent = new Intent(LoginActivity.this,ChatActivity.class);
                intent.putExtra("userName",userName);
                intent.putExtra("passWord",passWord);
                startActivity(intent);
            }
        });

        //注册按钮
        Button registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击事件，写入用户名和密码，跳转到聊天界面
                String userName = findViewById(R.id.username).getContext().toString();
                String passWord = findViewById(R.id.password).getContext().toString();
                Log.d("userName",userName);
                Log.d("passWord",passWord);
                Intent intent = new Intent(LoginActivity.this,ChatActivity.class);
                intent.putExtra("userName",userName);
                intent.putExtra("passWord",passWord);
                startActivity(intent);
            }
        });
    }
}
