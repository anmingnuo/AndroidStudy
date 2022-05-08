package com.example.androidstudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private  NotificationManager manager;
    private Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("amn","test",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,intent,0);

        notification = new NotificationCompat.Builder(this, "amn")
                .setContentTitle("官方通知")
                .setContentText("世界那么大，你想去看看吗")//设置文本内容
                .setSmallIcon(R.drawable.f2)//设置小图标例如提示栏的qq图标
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.f1))//设置右侧大图标
                .setColor(Color.parseColor("#ff0000"))//将颜色转化为rjb
                .setContentIntent(pendingIntent)//一点就进入APP
                .setAutoCancel(true)//一点击就取消
                .build();
    }
    public void sendNotification(View view){
        manager.notify(1,notification);
    }

    public void cancelNotification(View view){
        manager.cancel(1);
    }
}