package com.examples.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BasicActivity {

    public static void actionStart(Context context,String arg1,String arg2) {
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("arg1",arg1);
        intent.putExtra("arg2",arg2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Button secondButton = findViewById(R.id.secondActivityButton);
        Button backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 获取父Intent，取出Intent中键名为extra_data的键值
                 */
                Intent pIntent = getIntent();
                String data_forward = pIntent.getStringExtra("data_forward");
                Log.d("SecondActivity", data_forward);

                Intent intent = new Intent();
                intent.putExtra("data_return", "click back");
                setResult(RESULT_OK, intent);

                /**
                 * 新建一个Intent，用于启动ThirdActivity
                 */
//                Intent NIntent = new Intent(SecondActivity.this, ThirdActivity.class);
//                startActivity(NIntent);

//                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent rIntent = new Intent();
        rIntent.putExtra("data_return","press back");
        setResult(RESULT_OK,rIntent);
        finish();
    }
}
