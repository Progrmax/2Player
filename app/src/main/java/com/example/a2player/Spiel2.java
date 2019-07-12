package com.example.a2player;

import androidx.appcompat.app.AppCompatActivity;

import android.app.StatusBarManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;

public class Spiel2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_spiel2);
        String s1 = Integer.toString(MainActivity.punktzahlSpieler1);
        String s2 = Integer.toString(MainActivity.punktzahlSpieler2);
        ((TextView) findViewById(R.id.Spieler1Score)).setText(s1);
        ((TextView) findViewById(R.id.Spieler2Score)).setText(s2);
        timer();
    }

    Timer timer = new Timer();
    final Handler handler = new Handler();

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
    int x = 0;
    public void timer2(){
        Timer timer = new Timer();
        if(x == 0) {
            changemethod();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changemethod2();
                    }
                });


            }
    },0,10);
    }

    double zeitzahl=0;boolean unsichtbar = false;int modVergleichVariable = 0;
    public void changemethod(){

        ((TextView) findViewById(R.id.ZeitAngabe)).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.ZeitAngabe2 )).setVisibility(View.VISIBLE);
        zeitzahl = (int) (Math.random()*10)+5; modVergleichVariable = (int)zeitzahl;

    }
    public void changemethod2(){
        String s1 = Integer.toString(MainActivity.punktzahlSpieler1);
        String s2 = Integer.toString(MainActivity.punktzahlSpieler2);
        zeitzahl = zeitzahl-0.01;
        ((TextView) findViewById(R.id.Spieler1Score)).setText(s1);
        ((TextView) findViewById(R.id.Spieler2Score)).setText(s2);
        if(zeitzahl-1 < modVergleichVariable/2){

            unsichtbar = true;

            ((TextView) findViewById(R.id.ZeitAngabe)).setText(" ? ");
            ((TextView) findViewById(R.id.ZeitAngabe2)).setText(" ? ");

        }
        if(unsichtbar==false) {
            String temp = Integer.toString((int)zeitzahl);

            ((TextView) findViewById(R.id.ZeitAngabe)).setText(temp);
            ((TextView) findViewById(R.id.ZeitAngabe2)).setText(temp);

        }


    }
    boolean stop = false;
    public void Spieler1Drückt(View v){
        NumberFormat n = NumberFormat.getInstance();
        n.setMaximumFractionDigits(2);
        String a = n.format(zeitzahl);
        if(stop == false){
        if(zeitzahl<0){
            MainActivity.punktzahlSpieler1 ++;
            ((TextView) findViewById(R.id.AnsageTextView)).setText("Perfekt! Der Timer ist vor "+  a +" abgelaufen!");
            ((TextView) findViewById(R.id.AnsageTextView2)).setText("Zu langsam! Der Timer ist vor "+  a +" abgelaufen!");

        }
        else{
            MainActivity.punktzahlSpieler1 --;
            ((TextView) findViewById(R.id.AnsageTextView)).setText("Du warst "+a+" Sekunden zu schnell!");
            ((TextView) findViewById(R.id.AnsageTextView2)).setText("Gut! Der Timer brauchte noch "+a+" Sekunden!");

        }
        }
        stop = true; resettimer();
    }
    public void Spieler2Drückt(View v){
        NumberFormat n = NumberFormat.getInstance();
        n.setMaximumFractionDigits(2);
        String a = n.format(zeitzahl);
        if(stop == false) {
            if (zeitzahl < 0) {
                MainActivity.punktzahlSpieler2 ++;
                ((TextView) findViewById(R.id.AnsageTextView2)).setText("Perfekt! " + "Der Timer ist vor " + a + " abgelaufen!");
                ((TextView) findViewById(R.id.AnsageTextView)).setText("Zu langsam! " + "Der Timer ist vor " + a + " abgelaufen!");

            } else {
                MainActivity.punktzahlSpieler2 --;
                ((TextView) findViewById(R.id.AnsageTextView2)).setText("Du warst " + a + " Sekunden zu schnell!");
                ((TextView) findViewById(R.id.AnsageTextView)).setText("Gut! Der Timer brauchte noch " + a + " Sekunden!");

            }
        }
        stop = true;resettimer();
    }
    public void resettimer(){

        //timer.cancel();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                finish();
                startActivity(getIntent());

                //stop= false;
                //zeitzahl = 0;
                //x = 1;
                //unsichtbar=false;
                //timer2();
            }
        },3000);


    }
}
