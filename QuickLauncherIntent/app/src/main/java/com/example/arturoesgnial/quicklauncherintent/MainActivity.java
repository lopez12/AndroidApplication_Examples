package com.example.arturoesgnial.quicklauncherintent;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button secondActivity = (Button) findViewById(R.id.secondActivity);

        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get Intent
                Intent startIntent = new Intent(getApplicationContext(),SecondAcicity.class);
                //Pass Info
                startIntent.putExtra("com.example.arturoesgnial.quicklauncherintent.String2Send","I SENT THIS!!");
                //StartNewActivity
                startActivity(startIntent);

            }
        });

        Button googleButton = (Button) findViewById(R.id.buttonGoogle);

        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String googlehttp = "http://www.google.com";
                Uri webaddress = Uri.parse(googlehttp);

                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW,webaddress);
                if(gotoGoogle.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(gotoGoogle);
                }
            }
        });
    }
}
