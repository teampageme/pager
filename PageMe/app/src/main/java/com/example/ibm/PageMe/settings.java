package com.example.ibm.PageMe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.ibm.pager__9_10.R;

public class settings extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        /*
        TODOS:

        Push notification on/off: https://developer.android.com/guide/topics/ui/notifiers/notifications.html
        Refreshing period setup
        Vibration length preference : https://developer.android.com/reference/android/os/Vibrator.html#vibrate(long[], int, android.media.AudioAttributes)
        Signing out : Exiting the app

        */
    }
}
