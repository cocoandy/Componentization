package com.cxz.testpro;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            Log.e("TAG", "------------------>2");
            startActivity(new Intent(MainActivity.this, TowMainActivity.class));
            return false;
        }
    });
//    static MainActivity mainActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Demo.activity = this;
//        mainActivity = this;
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                finish();
            }
        });

        test();
    }

    public void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                handler.sendEmptyMessage(3);
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "------------------>1");
    }
}
