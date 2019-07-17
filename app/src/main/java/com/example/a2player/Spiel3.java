package com.example.a2player;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Spiel3 extends AppCompatActivity {
    final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiel3);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        start();


    }
    public void start(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((TextView) findViewById(R.id.Spielbedingungen1)).setVisibility(View.GONE);
                ((TextView) findViewById(R.id.Spielbedingungen2)).setVisibility(View.GONE);
                ((TextView) findViewById(R.id.TextViewSpiel)).setVisibility(View.VISIBLE);
                 timer();


            }
        },3000);






    }

    final int[] plus = {0};
    final int[] minus = {0};
    int c = 0;
    int e = 0;
    int f = 0;
    int schnell = 10;
    final String[] d = {""};
    final String[] s = new String[401];
    public void timer(){

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                final int a = (int) (Math.random()*2+1);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(a==1) {
                            s[c] = "+";
                            plus[0]++;
                        }else {
                            s[c] = "-";
                            minus[0]++;
                        }
                        c++;
                        d[0]="";
                        if(f<400){
                            f=c;
                        }
                        for(int i=0; i<f; i++){

                            d[0] =  d[0] + s[i];

                        }
                        ((TextView) findViewById(R.id.TextViewSpiel)).setText(d[0]);
                        e++;
                        if(e ==400){
                            c = 0;
                            schnell = 100;
                            e=0;

                        }



                    }
                });


            }
        },0,schnell);
    }
    public void Spieler1Drückt(View v){

        System.out.println(plus[0]);
        System.out.println(minus[0]);

    }
    public void Spieler2Drückt(View v){



    }


}


