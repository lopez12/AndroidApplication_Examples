package com.example.arturoesgnial.intentapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        if(getIntent().hasExtra("com.example.arturoesgnial.intentapplication.IDNOMBRE"))
        {
            TextView textodeXML = (TextView) findViewById(R.id.textView);
            String TextoRecibido = getIntent().getExtras().getString("com.example.arturoesgnial.intentapplication.IDNOMBRE");
            textodeXML.setText(TextoRecibido);
        }
    }
}
