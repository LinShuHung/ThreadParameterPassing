package com.suhun.threadparameterpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView showBroadcast, showMessageSend;
    public AppData appData;
    public BroadCastThread broadCastThread;
    public MessageHandlerThread messageHandlerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        appData = (AppData)getApplication();
        appData.myBroadcastReceiver = new MyBroadcastReceiver(this);
        appData.myMessageHandler = new MyMessageHandler(this);
    }
    private void initView(){
        showBroadcast = findViewById(R.id.broadcastResult);
        showMessageSend = findViewById(R.id.MessageResult);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(appData.myBroadcastReceiver, new IntentFilter("suhun"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(appData.myBroadcastReceiver);
    }

    public void runBroadcastPassingFun(View view){
        if(broadCastThread==null){
            broadCastThread = new BroadCastThread(this);
            broadCastThread.start();
        }
    }

    public void runMessagePassingFun(View view){
        if(messageHandlerThread==null){
            messageHandlerThread = new MessageHandlerThread(this);
            messageHandlerThread.start();
        }
    }
}