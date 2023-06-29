package com.suhun.threadparameterpassing;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;

public class MessageHandlerThread extends Thread{
    private String tag = MessageHandlerThread.class.getSimpleName();
    private MainActivity mainActivity;

    public MessageHandlerThread(Context context){
        mainActivity = (MainActivity)context;
    }
    @Override
    public void run() {
        super.run();
        runMessageHandlerMethod();
    }

    private void runMessageHandlerMethod(){
        for(int i=1;i<=20;i++){
            Log.d(tag, "+++++MessageHandlerThread+++++"+i);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                Log.d(tag, "+++++MessageHandlerThread+++++"+e.getMessage());
            };
            Message msg = new Message();
            Bundle bundle = new Bundle();
            msg.what = 0;
            bundle.putString("messageHandlerResult", ""+i);
            msg.setData(bundle);
            mainActivity.appData.myMessageHandler.sendMessage(msg);
        }
    }
}
