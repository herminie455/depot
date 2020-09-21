package com.example.hphilippe_di_tp3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoVue = findViewById(R.id.vueVideo);

        Uri uriPath = Uri.parse("android.resource://".concat(getPackageName()).concat("/raw/")+R.raw.landing);
        videoVue.setVideoURI(uriPath);
        videoVue.requestFocus();

        videoVue.start();

        MediaPlayer mp1;
        mp1 = MediaPlayer.create(this, R.raw.babychicks);
        mp1.start();

        int SPLASH_TIME_OUT = 6000;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent interfaceGalerie = new Intent (MainActivity.this, InfoPresentation.class);
                startActivity(interfaceGalerie);
                finish();
            }
        }, SPLASH_TIME_OUT);


        /*
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, InfoPresentation.class));
            }
        }, 6000);

         */

    }
}