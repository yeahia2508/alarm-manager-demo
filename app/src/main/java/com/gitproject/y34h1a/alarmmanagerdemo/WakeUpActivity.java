package com.gitproject.y34h1a.alarmmanagerdemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class WakeUpActivity extends AppCompatActivity {
    Button btStopAlarm;
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wake_up);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btStopAlarm = (Button) findViewById(R.id.btAlarmStop);

        startRingtone();
        setUpFab();

        btStopAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.stop();
                Snackbar.make(v, "Alarm Stopped!", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

    }

    private void startRingtone() {
        //play ringtone
        Uri ringtone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        mMediaPlayer = MediaPlayer.create(this, ringtone);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();
    }

    private void setUpFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"yeahia.arif@gmail.com"});
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail"));
                } catch (android.content.ActivityNotFoundException ex) {
                }
            }
        });
    }

}
