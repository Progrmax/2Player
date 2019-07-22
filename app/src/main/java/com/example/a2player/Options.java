package com.example.a2player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class Options extends AppCompatActivity {

    Switch darkmodeSwitch;
    Switch Musik;
    RelativeLayout rl;
    MediaPlayer mysound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);


        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        darkmodeSwitch = (Switch) findViewById(R.id.darkmodeSwitch);
        Musik = (Switch) findViewById(R.id.Musik);
        rl = (RelativeLayout) findViewById(R.id.rL1);

        //mysound = MediaPlayer.create(this, R.raw.background);
        //mysound.start();
        //mysound.setLooping(true);

        Musik.setChecked(true);

    }
    public static boolean MusikONOFF=false;
    public static boolean MusikOFF=false;
    public static boolean MusikON=false;
    public static boolean DarkOFF=false;
    public static boolean DarkON=false;
    @Override
    protected void onResume() {
        super.onResume();

        darkmodeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked) {
                    rl.setBackgroundColor(getResources().getColor(R.color.black));
                } else {
                    rl.setBackgroundColor(getResources().getColor(R.color.aqua));
                }


            }


        });


        Musik.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked) {
                    MusikONOFF=true;
                    MainActivity.mysound.start();
                } else {
                    MusikONOFF=false;
                    MainActivity.mysound.pause();
                }
            }
        });

    }
}