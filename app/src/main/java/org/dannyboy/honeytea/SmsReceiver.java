package org.dannyboy.honeytea;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static android.provider.Telephony.Sms.Intents.getMessagesFromIntent;

public class SmsReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        context.getContentResolver();
        SmsMessage[] messages = getMessagesFromIntent(intent);
        for (SmsMessage message : messages) {
            String originatingAddress = message.getOriginatingAddress();
            String text = message.getMessageBody();
            Toast.makeText(context, originatingAddress + " " + text, Toast.LENGTH_LONG).show();
            if (containsLinks(text)) {

                String warning = "Message received from " + originatingAddress + " contains url. Be careful when following url's from text messages. it might be a fishing attempt";
                Toast.makeText(context, warning, Toast.LENGTH_LONG).show();
                abortBroadcast();
                return;
            }
        }
    }

    private boolean containsLinks(String text) {
        for (String word : text.split("[\\n\\s]+")) {
            if (word.startsWith("http")) {
                return true;
            }
        }
        return false;
    }



}
