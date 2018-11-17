package com.example.arturoesgnial.intentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Code Here

        Button botonDeCambio = (Button) findViewById(R.id.IDBotonCambio);

        botonDeCambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent necesita 2 parametros (El contexto de la aplicacion , a que actividad brincar)
                Intent IrASegundaActividad = new Intent(getApplicationContext(),SegundaActividad.class);
                IrASegundaActividad.putExtra("com.example.arturoesgnial.intentapplication.IDNOMBRE","Artiuro Lopez");
                startActivity(IrASegundaActividad);
            }
        });

    }


}
