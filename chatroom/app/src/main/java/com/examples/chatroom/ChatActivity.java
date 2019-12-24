package com.examples.chatroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chat);
        Intent intent = getIntent();

        String userName = intent.getStringExtra("userName");
        Log.d("userName",userName);
        String passWord = intent.getStringExtra("passWord");
        Log.d("passWord",passWord);

    }



}
