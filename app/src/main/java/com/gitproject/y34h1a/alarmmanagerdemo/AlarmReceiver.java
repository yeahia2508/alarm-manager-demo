package com.gitproject.y34h1a.alarmmanagerdemo;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.PowerManager;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

/**
 * Created by y34h1a on 12/29/15.
 */
public class AlarmReceiver extends WakefulBroadcastReceiver {
    private PowerManager mPowerManager;
    private PowerManager.WakeLock mWakeLock;
    @Override
    public void onReceive(Context context, Intent intent) {

        mPowerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        turnOnScreen();
        Intent wakeIntent = new Intent();
        wakeIntent.setClassName("com.gitproject.y34h1a.alarmmanagerdemo", "com.gitproject.y34h1a.alarmmanagerdemo.WakeUpActivity");
        wakeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(wakeIntent);

    }

    public void turnOnScreen(){
        // turn on screen
        Log.v("ProximityActivity", "ON!");
        mWakeLock = mPowerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "tag");
        mWakeLock.acquire();
    }
}
