package com.examples.activitylab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this,"从第二个活动返回",Toast.LENGTH_LONG).show();
        super.onBackPressed();
    }
}
