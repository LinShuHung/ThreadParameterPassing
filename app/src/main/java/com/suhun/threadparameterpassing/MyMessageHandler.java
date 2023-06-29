package com.suhun.threadparameterpassing;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MyMessageHandler extends Handler {
    private MainActivity mainActivity;
    public MyMessageHandler(Context context){
        mainActivity = (MainActivity)context;
    }
    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        if(msg.what==0){
            String result = msg.getData().get("messageHandlerResult").toString();
            mainActivity.showMessageSend.setText(result);
            if(result.equals("20")){
                Toast.makeText(mainActivity, "Finish", Toast.LENGTH_LONG).show();
                mainActivity.messageHandlerThread = null;
            }
        }
    }
}
