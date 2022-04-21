package org.dannyboy.honeytea;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class NotificationCreation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    public void createNotificationChannel() {
        // creation of notification channel
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(NotificationProperties.CHANNEL_ID, NotificationProperties.CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(NotificationProperties.CHANNEL_DESCRIPTION);

            //creation of notification manager
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
    }
    public void createNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NotificationProperties.CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(NotificationProperties.NOTIFICATION_TITLE)
                .setContentText(NotificationProperties.NOTIFICATION_DESCRIPTION)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NotificationProperties.NOTIFICATION_ID,builder.build());

    }



}