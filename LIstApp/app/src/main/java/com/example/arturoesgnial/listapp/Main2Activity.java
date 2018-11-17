package com.example.arturoesgnial.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.webkit.ConsoleMessage;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent init = getIntent();
        int index = init.getIntExtra("com.example.arturoesgnial.listapp.ITEMINDEX",-1);

        ImageView Imagen = (ImageView) findViewById(R.id.imageView);

        if(index == -1)
        {
            Log.d("Error","No Index Data");
        }
        else if(index == 0)
        {
            Imagen.setImageResource(R.drawable.silla);
        }
        else if(index == 1)
        {
            Imagen.setImageResource(R.drawable.sofa);
        }
        else if (index == 2)
        {
            Imagen.setImageResource(R.drawable.mesa);
        }
        else
        {
            Log.d("Not Found", "No item Clicked");
        }

        /*Intent in = getIntent();
        int index = in.getIntExtra("com.example.arturoesgnial.listapp.ITEMINDEX", -1);

        if(index > -1)
        {
            int pic = setImage(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaling(img,pic);
        }*/

    }

    private int setImage(int index)
    {
        switch (index)
        {
            case 0: return R.drawable.silla;
            case 1: return R.drawable.sofa;
            case 2: return R.drawable.mesa;
            default: return -1;
        }
    }

    private void scaling(ImageView img, int pic)
    {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(),pic,options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if(imgWidth > screenWidth)
        {
            int ratio = Math.round((float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(),pic,options);
        img.setImageBitmap(scaledImg);
    }
}
