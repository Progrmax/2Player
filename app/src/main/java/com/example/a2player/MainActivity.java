package com.example.a2player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer = new Timer();
    final Handler handler = new Handler();
    public static int punktzahlSpieler1 = 0;
    public static int punktzahlSpieler2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);
        MediaPlayer mysound = MediaPlayer.create(this, R.raw.background);
        mysound.start();

        showButtons();

    }

    private void showButtons() {
        final int[] a = {0};


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(a[0] ==0){
                            ((TextView) findViewById(R.id.SpielstartenTextView)).setVisibility(View.VISIBLE);
                            a[0] =1;
                        }else{
                            ((TextView) findViewById(R.id.SpielstartenTextView)).setVisibility(View.INVISIBLE);
                            a[0] =0;
                        }
                    }
                }, 100); // produce 20 sec delay in button visibility


            }
            },10,1000);


        }
        public void buttonOnClick1(View v){

            timer.cancel();
            handler.removeMessages(0);
            Intent SpielIntent = new Intent(MainActivity.this, SpielAuswahl.class );
            startActivity(SpielIntent);


        }
}




