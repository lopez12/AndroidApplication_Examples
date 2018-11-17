package com.example.arturoesgnial.miprimeraplicacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonsuma = (Button) findViewById(R.id.BotonSuma);
        botonsuma.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int numero1;
        EditText edit1 = (EditText) findViewById(R.id.numero1);
        numero1 = Integer.parseInt(edit1.getText().toString());

        int numero2;
        EditText edit2 = (EditText) findViewById(R.id.numero2);
        numero2 = Integer.parseInt(edit2.getText().toString());

        int resultado;

        resultado = numero1 + numero2;

        TextView textoresultado = (TextView) findViewById(R.id.resultadoSuma);
        textoresultado.setText(resultado + "");

    }
}
