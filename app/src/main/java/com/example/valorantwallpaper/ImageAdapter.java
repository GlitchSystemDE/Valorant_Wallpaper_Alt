package com.example.valorantwallpaper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public int[] bilderArray = {
            R.drawable.ladebildschirm,R.drawable.testblau,R.drawable.testgruen,R.drawable.testrot,R.drawable.ladebildschirmval
    };

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return bilderArray.length;
    }

    @Override
    public Object getItem(int position) {
        return bilderArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(bilderArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(550, 1000));

        return imageView;
    }
}