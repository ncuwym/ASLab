package com.examples.activitylab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.time.LocalDate;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Intent intent = getIntent();
        Person p = (Person) intent.getSerializableExtra("personInfo");
        Log.d("person", p.getName());
        LocalDate date = p.getBirthDay();
        Log.d("person", ""+ p.getBirthDay());
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,"从第一个活动返回",Toast.LENGTH_LONG).show();
        super.onBackPressed();
    }
}
