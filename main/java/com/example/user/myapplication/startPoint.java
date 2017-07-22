package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

/**
 * Created by user on 22/07/2017.
 */

public class startPoint extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    Intent open = new Intent("com.example.user.myapplication.MAINACTIVITY");
                    startActivity(open);
                }

            }
        };
        timer.start();
    }
    protected void onPause(){
        super.onPause();
        setContentView(R.layout.developer);
    }
}
