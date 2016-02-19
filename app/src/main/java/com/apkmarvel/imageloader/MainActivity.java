package com.apkmarvel.imageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.apkmarvel.imageloader.imageloader.ImageLoader;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cast();
    }

    private void cast() {
        imageView=(ImageView)findViewById(R.id.image);
        pb =(ProgressBar)findViewById(R.id.pbImg);
    }
    public void load(View v){
        ImageLoader imageLoader = new ImageLoader(this);
        imageLoader.setImageUrl("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg");
        imageLoader.setImageView(imageView);
        imageLoader.setSize(800,800);
        imageLoader.setProgressBar(pb);
        imageLoader.load();
    }
}
