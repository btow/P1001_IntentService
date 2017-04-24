package com.example.samsung.p1001_intentservice;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import java.util.concurrent.TimeUnit;

public class MyIntentService extends IntentService {

    private NotificationManager notificationManager;
    private Notification notification;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        String message = "MyIntentService onCreate()";
        Messager.sendMessageToAllRecipients(this, message);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        int tm          = intent.getIntExtra(getString(R.string.time), 0);
        String label    = intent.getStringExtra(getString(R.string.label));
        String message  = "MyIntentService onHandleIntent() start " + label;
        Messager.sendMessageToAllRecipients(this, message);
        sendNotification(message);
        try {
            TimeUnit.SECONDS.sleep(tm);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        message = "MyIntentService onHandleIntent() finish " + label;
        Messager.sendMessageToAllRecipients(this, message);
    }

    private void sendNotification(final String message) {
        //Создание активити для отображения подробностей
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        //Подготовка уведомления в статус-бар
        Notification.Builder builder = new Notification.Builder(MyIntentService.this);
        //Установка сообщения для статус-бара
        builder.setContentText(message);
        //Установка стикера
        builder.setTicker("Notification's ticker");
        //Установка заголовка
        builder.setContentTitle("Notification's title");
        //Установка малой иконки
        builder.setSmallIcon(R.mipmap.ic_launcher);
        //Подключение активити к записи
        builder.setContentIntent(pendingIntent);
        builder.setOngoing(true);
        //Только для API не младше №16
//        builder.setSubText("The notification's subtext");
        //Создание строки в разворачивающемся списке уведомлений
        notification = builder.getNotification();
        //Отправка уведомления в статус-бар
        startForeground(1, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        String message = "MyIntentService onDestroy()";
        Messager.sendMessageToAllRecipients(this, message);
    }
}
