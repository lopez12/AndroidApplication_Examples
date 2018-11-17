package com.example.arturoesgnial.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView ListaID;
    String[] Objetos;
    String[] Descripcion;
    String[] Precios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        ListaID = (ListView) findViewById(R.id.ListaID);
        Objetos = res.getStringArray(R.array.ObjetosdeLista);
        Descripcion = res.getStringArray(R.array.DescripcionObjetos);
        Precios = res.getStringArray(R.array.PrecioObjetos);

        //ListaID.setAdapter(new ArrayAdapter<String>(this,R.layout.my_listview_detail,items));
        ItemAdapter itemAdapter = new ItemAdapter(this,Objetos,Precios,Descripcion);
        ListaID.setAdapter(itemAdapter);

        ListaID.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent GoActivity2 = new Intent(getApplicationContext(),Main2Activity.class);
               GoActivity2.putExtra("com.example.arturoesgnial.listapp.ITEMINDEX",i);
               startActivity(GoActivity2);
           }
        });

        /*ListaID.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showActivity2 = new Intent(getApplicationContext(),Main2Activity.class);
                showActivity2.putExtra("com.example.arturoesgnial.listapp.ITEMINDEX",i);
                startActivity(showActivity2);
            }
        });*/

    }

}
