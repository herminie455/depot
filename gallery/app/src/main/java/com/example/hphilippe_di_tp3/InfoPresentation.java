package com.example.hphilippe_di_tp3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InfoPresentation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_presentation);

        MediaPlayer mp1;
        mp1 = MediaPlayer.create(this, R.raw.peacock);
        mp1.start();

        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent interfaceGalerie = new Intent (InfoPresentation.this, GalerieImages.class);
                startActivity(interfaceGalerie);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}