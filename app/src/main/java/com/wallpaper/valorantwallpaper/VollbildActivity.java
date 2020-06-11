package com.wallpaper.valorantwallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.IOException;
import java.util.Objects;


public class VollbildActivity extends AppCompatActivity {
    ImageView imageView;
    AdView AdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vollbild);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        AdView.loadAd(adRequest);


        imageView = (ImageView) findViewById(R.id.image_view);
        Intent i = getIntent();
        int position = Objects.requireNonNull(i.getExtras()).getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);
        imageView.setImageResource(imageAdapter.bilderArray[position]);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setWallpaper();
            }
        });
    }

    private void setWallpaper(){imageView = (ImageView) findViewById(R.id.image_view);
        Intent i = getIntent();
        int position = Objects.requireNonNull(i.getExtras()).getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageAdapter.bilderArray[position]);
        WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());

        try {
            manager.setBitmap(bitmap);
            Toast.makeText(this, "Background was set", Toast.LENGTH_SHORT).show();
        } catch (IOException e){
            Toast.makeText(this,"Error!", Toast.LENGTH_SHORT).show();
        }
    }
}