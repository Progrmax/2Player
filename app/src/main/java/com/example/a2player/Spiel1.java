package com.example.a2player;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Spiel1 extends AppCompatActivity {

    Timer timer = new Timer();
    final Handler handler = new Handler();
    boolean go = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ((TextView) findViewById(R.id.Spieler2Score)).setText(Integer.toString(MainActivity.punktzahlSpieler1));
        ((TextView) findViewById(R.id.Spieler2Score)).setText(Integer.toString(MainActivity.punktzahlSpieler2));

        setContentView(R.layout.activity_spiel1);
        timer();
    }
    public void timer() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((TextView) findViewById(R.id.Spielbedingungen1)).setVisibility(View.GONE);
                ((TextView) findViewById(R.id.Spielbedingungen2)).setVisibility(View.GONE);
                timer2();
            }
        }, 3000);
    }
    int sec = 0;boolean punkt=false; public int score1=0; public int score2=0;boolean stop = false;
    public void timer2(){

        sec = (int) (Math.random()*10000)+2000;

        final int[] finalSec = {sec};
        timer.schedule(new TimerTask() {
            @Override
               public void run() {
               handler.postDelayed(new Runnable() {
                   @Override
                       public void run() {
                       finalSec[0] = sec;
                                changemethod();
                            }
                        }, finalSec[0]);
                    changemethod2();
                    }
                },100,2500);
            }
    public void changemethod(){
        ImageView tw =  ((ImageView) findViewById(R.id.SpielHellImageView));
        sec = (int) (Math.random()*10000)+3000;
        if(go==false && stop == false) {
            tw.setVisibility(View.VISIBLE);
            tw.setBackgroundColor(getResources().getColor(R.color.white));
            go= true;punkt = true;
        }
    }
    public void changemethod2() {
        ImageView tw = ((ImageView) findViewById(R.id.SpielHellImageView));
        if (go == true) {
            tw.setVisibility(View.INVISIBLE);
            tw.setBackgroundColor(getResources().getColor(R.color.black));
            go = false;
            punkt = false;
            changemethod3();
        }
    }
    public void changemethod3(){

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                ((TextView) findViewById(R.id.AnsageTextView)).setText("");
                ((TextView) findViewById(R.id.AnsageTextView2)).setText("");
                stop = false;

            }
        },3000);

    }
    public void Spieler1Drückt(View v){
        if(punkt==true  && stop == false){
            stop = true;
            MainActivity.punktzahlSpieler1++;
            ((TextView) findViewById(R.id.Spieler1Score)).setText(Integer.toString(MainActivity.punktzahlSpieler1));
            ((TextView) findViewById(R.id.AnsageTextView)).setText("Super !");
            ((TextView) findViewById(R.id.AnsageTextView2)).setText("Zu langsam !");

        }else if(punkt == false && stop == false){
            MainActivity.punktzahlSpieler1--;
            ((TextView) findViewById(R.id.Spieler1Score)).setText(Integer.toString(MainActivity.punktzahlSpieler1));
            ((TextView) findViewById(R.id.AnsageTextView)).setText("Zu früh/spät !");
        }
    }
    public void Spieler2Drückt(View v){
        if(punkt==true && stop == false){
            stop =true;
            MainActivity.punktzahlSpieler2++;
            ((TextView) findViewById(R.id.Spieler2Score)).setText(Integer.toString(MainActivity.punktzahlSpieler2));
            ((TextView) findViewById(R.id.AnsageTextView2)).setText("Super !");
            ((TextView) findViewById(R.id.AnsageTextView)).setText("Zu langsam !");
        }else if(punkt == false && stop == false){
            MainActivity.punktzahlSpieler2--;
            ((TextView) findViewById(R.id.Spieler2Score)).setText(Integer.toString(MainActivity.punktzahlSpieler2));
            ((TextView) findViewById(R.id.AnsageTextView2)).setText("Zu früh/spät !");
        }
    }


}


