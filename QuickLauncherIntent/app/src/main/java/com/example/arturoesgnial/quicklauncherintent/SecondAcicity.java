package com.example.arturoesgnial.quicklauncherintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondAcicity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acicity);

        if(getIntent().hasExtra("com.example.arturoesgnial.quicklauncherintent.String2Send"))
        {
            TextView secondtext = (TextView) findViewById(R.id.textView);
            String textReceived = getIntent().getExtras().getString("com.example.arturoesgnial.quicklauncherintent.String2Send");
            secondtext.setText(textReceived);
        }
    }
}
