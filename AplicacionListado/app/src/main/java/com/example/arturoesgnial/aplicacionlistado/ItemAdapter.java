package com.example.arturoesgnial.aplicacionlistado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Arturo Es Gnial on 17/04/2018.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    public String[] Objetos;

    public ItemAdapter(Context c, String[] o)
    {
        Objetos = o;
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
        View v = mInflater.inflate(R.layout.articulosdelista,null);

        TextView nameTextView = (TextView) v.findViewById(R.id.textViewNombre);

        String name = Objetos[i];

        nameTextView.setText(name);

        return v;
    }
}
