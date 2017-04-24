package com.example.samsung.p1001_intentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = "MyReceiver onReceive(): " + intent.getAction();
        Messager.sendMessageToAllRecipients(context, message);
        Intent serviceIntent = new Intent(context, MyIntentService.class);
        context.startService(serviceIntent);
    }
}
