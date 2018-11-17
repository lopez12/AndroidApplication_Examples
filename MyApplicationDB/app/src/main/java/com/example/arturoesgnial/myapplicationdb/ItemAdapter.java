package com.example.arturoesgnial.myapplicationdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * Created by Arturo Es Gnial on 26/04/2018.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    Map<String,Double> mapObjects;
    List<String> nombreObjetos;
    List<Double> precioObjetos;

    public ItemAdapter(Context c, Map m)
    {
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mapObjects = m;
        nombreObjetos = new ArrayList<String>(mapObjects.keySet());
        precioObjetos = new ArrayList<Double>(mapObjects.values());
    }

    @Override
    public int getCount() {
        return mapObjects.size();
    }

    @Override
    public Object getItem(int i) {
        return mapObjects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.item_layout,null);
        TextView nameTextView = (TextView) v.findViewById(R.id.objNameTxt);
        TextView precioTextView = (TextView) v.findViewById(R.id.objPriceTxt);

        nameTextView.setText(nombreObjetos.get(i));
        precioTextView.setText("$" + precioObjetos.get(i).toString());
        /*View v = mInflater.inflate(R.layout.item_layout,null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTxt);
        TextView PrecioTextID = (TextView) v.findViewById(R.id.priceTxt);

        nameTextView.setText(Objetos.get(i));
        PrecioTextID.setText("$" + Precios.get(i).toString());

        return v;*/
        return v;
    }
}
