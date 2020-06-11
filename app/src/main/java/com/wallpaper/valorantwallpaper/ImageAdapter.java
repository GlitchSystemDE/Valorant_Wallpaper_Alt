package com.wallpaper.valorantwallpaper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public int[] bilderArray = {
            R.drawable.hintergrund1,R.drawable.hintergrund2,R.drawable.hintergrund3,R.drawable.hintergrund4,R.drawable.hintergrund5,
            R.drawable.hintergrund6,R.drawable.hintergrund7,R.drawable.hintergrund8,R.drawable.hintergrund9,R.drawable.hintergrund10,
            R.drawable.hintergrund11,R.drawable.hintergrund12
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
