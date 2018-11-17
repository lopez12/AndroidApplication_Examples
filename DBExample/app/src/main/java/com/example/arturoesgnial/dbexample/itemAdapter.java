package com.example.arturoesgnial.dbexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Arturo Es Gnial on 26/04/2018.
 */

public class itemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    Map<String,Double> map;
    List<String> Objetos;
    List<Double> Precios;

    public itemAdapter(Context c, Map m)
    {
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        map = m;
        Objetos = new ArrayList<String>(map.keySet());
        Precios = new ArrayList<Double>(map.values());
    }

    @Override
    public int getCount() {
        return map.size();
    }

    @Override
    public Object getItem(int i) {
        return Objetos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.item_layout,null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTxt);
        TextView PrecioTextID = (TextView) v.findViewById(R.id.priceTxt);

        nameTextView.setText(Objetos.get(i));
        PrecioTextID.setText("$" + Precios.get(i).toString());

        return v;
    }
}
