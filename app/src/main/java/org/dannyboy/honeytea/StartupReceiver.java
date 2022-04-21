package org.dannyboy.honeytea;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

public class StartupReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("startup-receiver", "Application has started, invoking scanner service");
        Intent serviceIntent = new Intent(context, ScannerService.class);
        context.startForegroundService(serviceIntent);
    }

}
