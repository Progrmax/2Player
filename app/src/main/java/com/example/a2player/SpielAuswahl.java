package com.example.a2player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class SpielAuswahl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_spiel_auswahl);
    }

    public void buttonOnClick2(View v){

        Intent SpielIntent = new Intent(SpielAuswahl.this, LevelAuswahl.class );
        startActivity(SpielIntent);
    }
    public void buttonOnClick3(View v){
        Intent SpielIntent = new Intent(SpielAuswahl.this, UnendlicherDurchlauf.class );
        startActivity(SpielIntent);

    }
}
