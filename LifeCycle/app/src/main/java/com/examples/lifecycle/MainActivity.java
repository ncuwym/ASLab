package com.examples.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAINACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "调用onCreate");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            String message = savedInstanceState.getString("temp_data");
            Log.d(TAG, message);
        }

        Button startNormal = findViewById(R.id.start_normal_activity);
        Button startDialog = findViewById(R.id.start_dialog_activity);

        startNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String temp_data = "this is temp data";
        outState.putString("message",temp_data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "调用onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "调用onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "调用onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "调用onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "调用onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "调用onDestroy");
    }


}
