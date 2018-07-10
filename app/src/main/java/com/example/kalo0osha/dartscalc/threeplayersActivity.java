package com.example.kalo0osha.dartscalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class threeplayersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threeplayers);

        final Spinner spinner1 =(Spinner) findViewById(R.id.spinnerone);
        final Spinner spinner2 =(Spinner) findViewById(R.id.spinnertwo);
        final Spinner spinner3 =(Spinner) findViewById(R.id.spinnerthree);



    }
}
