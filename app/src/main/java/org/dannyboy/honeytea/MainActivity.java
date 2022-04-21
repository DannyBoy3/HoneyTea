package org.dannyboy.honeytea;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.RECEIVE_SMS, Manifest.permission.BROADCAST_SMS,  "android.provider.Telephony.SMS_RECEIVED"},
                69);

        Intent intent = new Intent(this, ScannerService.class);
        this.startForegroundService(intent);

        setContentView(R.layout.activity_main);
        Toast.makeText(this, "test1", Toast.LENGTH_LONG).show();
    }

}