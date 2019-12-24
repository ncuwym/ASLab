package com.examples.activitytest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        Button firstButton = findViewById(R.id.firstActivityButton);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 使用隐式Intent启动SecondActivity，并向SecondActivity传递数据
                 */
                SecondActivity.actionStart(FirstActivity.this, "1", "2");

                Intent intent = new Intent("com.examples.activityTest.ACTION_START");
                String data_forward = "forward";
                intent.putExtra("data_forward", data_forward);
//                startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

    @Override
    /* 重写创建菜单的方法*/
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        
        Intent intent2 = new Intent(FirstActivity.this, DialogActivity.class);
        startActivity(intent2);
        //true;display,
        //false:no display
        return true;
    }

    @Override
    /* 重写菜单点击事件 */
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "you clicked add", Toast.LENGTH_LONG).show();
//                setIntent(new Intent(FirstActivity.this,DialogActivity.class));
//                Intent intent2 = new Intent(FirstActivity.this,DialogActivity.class);
//                startActivity(intent2);
                setContentView(R.layout.activity_dialog);
                break;
            case R.id.remove_item:
                Toast.makeText(this, "you clicked remove", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


}
