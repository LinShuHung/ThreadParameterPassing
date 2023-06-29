package com.suhun.threadparameterpassing;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BroadCastThread extends Thread{
    private MainActivity mainActivity;

    public BroadCastThread(Context context){
        mainActivity = (MainActivity)context;
    }
    private String tag = BroadCastThread.class.getSimpleName();
    @Override
    public void run() {
        super.run();
        runMethod();
    }

    private void runMethod(){
        for(int i=1;i<=20;i++){
            Log.d(tag, "+++++BroadCastThread+++++"+i);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                Log.d(tag, e.getMessage());
            }
            Intent intent = new Intent("suhun");
            intent.putExtra("broadcastResult", ""+i);
            mainActivity.sendBroadcast(intent);
            if(i==20&&mainActivity.broadCastThread!=null){
                mainActivity.broadCastThread = null;
            }
        }
    }
}
