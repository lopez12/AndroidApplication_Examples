package com.example.arturoesgnial.connectinternet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button GoogleButton = (Button) findViewById(R.id.buttonGoogleID);

        GoogleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URLString = "http://google.com";
                Uri URLDirection = Uri.parse(URLString);

                Intent GoogleConenction = new Intent(Intent.ACTION_VIEW,URLDirection);
                if(GoogleConenction.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(GoogleConenction);
                }
            }
        });
    }
}
