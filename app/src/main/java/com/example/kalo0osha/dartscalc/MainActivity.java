package com.example.kalo0osha.dartscalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton twoPlayers_btn=(ImageButton) findViewById(R.id.twoplayers_btn);
        twoPlayers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,twoplayersActivity.class);
                startActivity(intent);

            }
        });

        ImageButton threePlayers_btn=(ImageButton) findViewById(R.id.threeplayers_btn);
        threePlayers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,threeplayersActivity.class);
                startActivity(intent);

            }
        });
    }
}
