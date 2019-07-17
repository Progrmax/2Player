package com.example.a2player;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Spiel1 extends AppCompatActivity {

    Timer timer;
    TimerTask task;
    View screen;

    TextView sp1;
    TextView sp2;

    boolean firsttimeexplaination = true;
    int n1, n2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_spiel1);

        sp1 = findViewById(R.id.Spielbedingungen1);
        sp2 = findViewById(R.id.Spielbedingungen2);

        timer = new Timer();
        task = new TimerTask(){
            @Override
            public void run() {
                changebackground();
            }
        };

        timer.schedule(task, 3000, 3000);




        screen = findViewById(R.id.gameonescreen);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ((TextView) findViewById(R.id.Spieler2Score)).setText(Integer.toString(MainActivity.punktzahlSpieler1));
        ((TextView) findViewById(R.id.Spieler2Score)).setText(Integer.toString(MainActivity.punktzahlSpieler2));

        screen.setBackgroundResource(R.color.black);

        sp1.setVisibility(View.VISIBLE);
        sp2.setVisibility(View.VISIBLE);

    }

    public void changegivencolortext(){


        n1 = (int) (Math.random()*10+1);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch(n1) {
                    case 1:
                        ((TextView) findViewById(R.id.Spielbedingungen1)).setText("Weiß");
                        ((TextView) findViewById(R.id.Spielbedingungen2)).setText("Weiß");
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.Spielbedingungen1)).setText("Grau");
                        ((TextView) findViewById(R.id.Spielbedingungen2)).setText("Grau");
                        break;
                    case 3:
                        ((TextView) findViewById(R.id.Spielbedingungen1)).setText("Gelb");
                        ((TextView) findViewById(R.id.Spielbedingungen2)).setText("Gelb");
                        break;
                    case 4:
                        ((TextView) findViewById(R.id.Spielbedingungen1)).setText("Grün");
                        ((TextView) findViewById(R.id.Spielbedingungen2)).setText("Grün");
                        break;
                    case 5:
                        ((TextView) findViewById(R.id.Spielbedingungen1)).setText("Rot");
                        ((TextView) findViewById(R.id.Spielbedingungen2)).setText("Rot");
                        break;
                    case 6:
                        ((TextView) findViewById(R.id.Spielbedingungen1)).setText("Pink");
                        ((TextView) findViewById(R.id.Spielbedingungen2)).setText("Pink");
                        break;
                    case 7:
                        ((TextView) findViewById(R.id.Spielbedingungen1)).setText("Braun");
                        ((TextView) findViewById(R.id.Spielbedingungen2)).setText("Braun");
                        break;
                    case 8:
                        ((TextView) findViewById(R.id.Spielbedingungen1)).setText("Blau");
                        ((TextView) findViewById(R.id.Spielbedingungen2)).setText("Blau");
                        break;
                    case 9:
                        ((TextView) findViewById(R.id.Spielbedingungen1)).setText("Orange");
                        ((TextView) findViewById(R.id.Spielbedingungen2)).setText("Orange");
                        break;
                    case 10:
                        ((TextView) findViewById(R.id.Spielbedingungen1)).setText("Violett");
                        ((TextView) findViewById(R.id.Spielbedingungen2)).setText("Violett");
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public void changebackground(){
        n2 = (int) (Math.random()*10+1);
        if(firsttimeexplaination){
            changegivencolortext();
            firsttimeexplaination = false;
        }

        else {
            sp1.setTextColor(getResources().getColor(R.color.black));
            sp2.setTextColor(getResources().getColor(R.color.black));
            ((TextView) findViewById(R.id.Spieler1Score)).setTextColor(getResources().getColor(R.color.black));
            ((TextView) findViewById(R.id.Spieler2Score)).setTextColor(getResources().getColor(R.color.black));
            ((TextView) findViewById(R.id.AnsageTextView)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.AnsageTextView2)).setVisibility(View.INVISIBLE);


            switch(n2) {
                case 1:
                    screen.setBackgroundResource(R.color.white);
                    break;
                case 2:
                    screen.setBackgroundResource(R.color.gray);
                    break;
                case 3:
                    screen.setBackgroundResource(R.color.yellow);
                    break;
                case 4:
                    screen.setBackgroundResource(R.color.green);
                    break;
                case 5:
                    screen.setBackgroundResource(R.color.red);
                    break;
                case 6:
                    screen.setBackgroundResource(R.color.pink);
                    break;
                case 7:
                    screen.setBackgroundResource(R.color.brown);
                    break;
                case 8:
                    screen.setBackgroundResource(R.color.blue);
                    break;
                case 9:
                    screen.setBackgroundResource(R.color.orange);
                    break;
                case 10:
                    screen.setBackgroundResource(R.color.violet);
                    break;
                default:
                    break;

            }
        }
    }

    public void Spieler1Drückt(View v){

        screen.setBackgroundResource(R.color.black);
        sp1.setVisibility(View.VISIBLE);
        sp2.setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.AnsageTextView)).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.AnsageTextView2)).setVisibility(View.VISIBLE);
        if(n1 == n2){
            MainActivity.punktzahlSpieler1++;
            ((TextView) findViewById(R.id.Spieler1Score)).setText(Integer.toString(MainActivity.punktzahlSpieler1));
            ((TextView) findViewById(R.id.AnsageTextView)).setText("Super !");
            ((TextView) findViewById(R.id.AnsageTextView2)).setText("Zu langsam !");
        }else if(n1 != n2){
            MainActivity.punktzahlSpieler1--;
            ((TextView) findViewById(R.id.Spieler1Score)).setText(Integer.toString(MainActivity.punktzahlSpieler1));
            ((TextView) findViewById(R.id.AnsageTextView)).setText("Zu früh/spät !");
        }
        screen.setBackgroundResource(R.color.black);
        sp1.setTextColor(getResources().getColor(R.color.white));
        sp2.setTextColor(getResources().getColor(R.color.white));
        ((TextView) findViewById(R.id.Spieler1Score)).setTextColor(getResources().getColor(R.color.white));
        ((TextView) findViewById(R.id.Spieler2Score)).setTextColor(getResources().getColor(R.color.white));
        changegivencolortext();
    }
    public void Spieler2Drückt(View v){
        screen.setBackgroundResource(R.color.black);
        sp1.setVisibility(View.VISIBLE);
        sp2.setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.AnsageTextView)).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.AnsageTextView2)).setVisibility(View.VISIBLE);
        if(n1 == n2){
            MainActivity.punktzahlSpieler2++;
            ((TextView) findViewById(R.id.Spieler2Score)).setText(Integer.toString(MainActivity.punktzahlSpieler2));
            ((TextView) findViewById(R.id.AnsageTextView2)).setText("Super !");
            ((TextView) findViewById(R.id.AnsageTextView)).setText("Zu langsam !");
        }else if(n1 != n2){
            MainActivity.punktzahlSpieler2--;
            ((TextView) findViewById(R.id.Spieler2Score)).setText(Integer.toString(MainActivity.punktzahlSpieler2));
            ((TextView) findViewById(R.id.AnsageTextView2)).setText("Zu früh/spät !");
        }

        screen.setBackgroundResource(R.color.black);
        sp1.setTextColor(getResources().getColor(R.color.white));
        sp2.setTextColor(getResources().getColor(R.color.white));
        ((TextView) findViewById(R.id.Spieler1Score)).setTextColor(getResources().getColor(R.color.white));
        ((TextView) findViewById(R.id.Spieler2Score)).setTextColor(getResources().getColor(R.color.white));
        changegivencolortext();
    }


}


