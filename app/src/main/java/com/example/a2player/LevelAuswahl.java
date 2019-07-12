package com.example.a2player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class LevelAuswahl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_auswahl);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
    public void Level1starten(View view){

        Intent SpielIntent = new Intent(LevelAuswahl.this, Spiel1.class );
        startActivity(SpielIntent);

    }
    public void Level2starten(View view){

        Intent SpielIntent = new Intent(LevelAuswahl.this, Spiel2.class );
        startActivity(SpielIntent);

    }
    public void Level3starten(View view){

        Intent SpielIntent = new Intent(LevelAuswahl.this, Spiel1.class );
        startActivity(SpielIntent);

    }
}
