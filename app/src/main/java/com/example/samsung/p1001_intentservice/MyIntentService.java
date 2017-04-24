package com.example.samsung.p1001_intentservice;

import android.app.IntentService;
import android.content.Intent;

import java.util.concurrent.TimeUnit;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        String message = "MyIntentService onCreate()";
        Messager.sendMessageToAllRecipients(this, message);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int tm          = intent.getIntExtra(getString(R.string.time), 0);
        String label    = intent.getStringExtra(getString(R.string.label));
        String message  = "MyIntentService onHandleIntent() start " + label;
        Messager.sendMessageToAllRecipients(this, message);
        try {
            TimeUnit.SECONDS.sleep(tm);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        message = "MyIntentService onHandleIntent() finish " + label;
        Messager.sendMessageToAllRecipients(this, message);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        String message = "MyIntentService onDestroy()";
        Messager.sendMessageToAllRecipients(this, message);
    }
}
