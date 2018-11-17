package com.example.arturoesgnial.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Arturo Es Gnial on 17/04/2018.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] Objetos;
    String[] Descripcion;
    String[] Precios;

    public ItemAdapter(Context c, String[] o, String[] p,String[] d)
    {
        Objetos = o;
        Precios = p;
        Descripcion = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return Objetos.length;
    }

    @Override
    public Object getItem(int i) {
        return Objetos[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.listview_detail,null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextViewID);
        TextView DescripcionID = (TextView) v.findViewById(R.id.DescripcionID);
        TextView PrecioTextID = (TextView) v.findViewById(R.id.PrecioTextID);

        String name = Objetos[i];
        String desc = Descripcion[i];
        String costo = Precios[i];

        nameTextView.setText(name);
        DescripcionID.setText(desc);
        PrecioTextID.setText(costo);

        return v;
    }
}
