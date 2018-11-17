package com.example.arturoesgnial.aplicacionlistado;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView ListaObjetos;
    String[] Departamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = getResources();

        Departamentos = res.getStringArray(R.array.Departamentos);

        ListaObjetos = (ListView) findViewById(R.id.ListViewID);

        ItemAdapter itemAdapter = new ItemAdapter(this,Departamentos);

        ListaObjetos.setAdapter(itemAdapter);

    }
}
