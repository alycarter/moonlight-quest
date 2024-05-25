package com.limelight;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class ResolutionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_resolution);

        findViewById(R.id.resolutionDefault).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenResolution(PcView.class);
            }
        });
        findViewById(R.id.resolutionFHD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenResolution(PcViewFHD.class);
            }
        });
        findViewById(R.id.resolutionQHD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenResolution(PcViewQHD.class);
            }
        });
        findViewById(R.id.resolutionUHD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenResolution(PcViewUHD.class);
            }
        });
        findViewById(R.id.resolutionWFHD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenResolution(PcViewWFHD.class);
            }
        });
        findViewById(R.id.resolutionWQHD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenResolution(PcViewWQHD.class);
            }
        });

    }

    public void OpenResolution(Class<?> activityClass)
    {
        Intent mStartActivity = new Intent(ResolutionActivity.this, activityClass);
        int mPendingIntentId = 123456;
        PendingIntent mPendingIntent = PendingIntent.getActivity(ResolutionActivity.this, mPendingIntentId, mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        AlarmManager mgr = (AlarmManager)ResolutionActivity.this.getSystemService(ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
        System.exit(0);
    }
}