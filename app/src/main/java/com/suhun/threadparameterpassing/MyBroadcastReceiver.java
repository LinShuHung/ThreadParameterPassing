package com.suhun.threadparameterpassing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private MainActivity mainActivity;

    public MyBroadcastReceiver(Context context){
        mainActivity = (MainActivity)context;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String result = intent.getStringExtra("broadcastResult");
        mainActivity.showBroadcast.setText(result);
    }
}
