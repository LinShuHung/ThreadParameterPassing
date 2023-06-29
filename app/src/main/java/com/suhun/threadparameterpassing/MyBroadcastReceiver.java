package com.suhun.threadparameterpassing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public String tag = MyBroadcastReceiver.class.getSimpleName();
    private MainActivity mainActivity;

    public MyBroadcastReceiver(Context context){
        mainActivity = (MainActivity)context;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String result = intent.getStringExtra("broadcastResult");
        mainActivity.showBroadcast.setText(result);
        if(result.equals("20")){
            Log.d(tag, "+++++Finish+++++");
            Toast.makeText(mainActivity, "Finish", Toast.LENGTH_LONG).show();
        }
    }
}
