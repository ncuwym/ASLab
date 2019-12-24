package com.examples.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//        private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter();
        //网络状态发生变化时，系统发出的广播值
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        //注册
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //动态注册的广播接收器一定要取消注册
        unregisterReceiver(networkChangeReceiver);
    }

    /**
     * 内部类NetworkChangeReceiver继承BroadcastReceiver，重写onReceive方法，
     * 首先通过getSystemService方法获得管理网络连接的系统服务类实例，
     * 调用它的getActiveNetworkInfo方法得到NetworkInfo的实例，
     * 接着调用NetworkInfo的isAvailable方法判断是否有网络，最后通过Toast显示
     */
    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectionManger = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectionManger.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "网络良好", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "网络无连接", Toast.LENGTH_LONG).show();
            }
        }
    }
}
