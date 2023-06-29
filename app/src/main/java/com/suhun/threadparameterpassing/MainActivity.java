package com.suhun.threadparameterpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView showBroadcast, showMessageSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        showBroadcast = findViewById(R.id.broadcastResult);
        showMessageSend = findViewById(R.id.MessageResult);
    }
    public void runBroadcastPassingFun(View view){

    }

    public void runMessagePassingFun(View view){

    }
}