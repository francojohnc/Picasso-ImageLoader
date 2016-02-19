package com.apkmarvel.imageloader.imageloader;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;




/**
 * Created by johncarlofranco.com on 2/15/2016.
 */
public class ImageLoader implements ImageloaderListener {
    //variables
    private ImageloaderListener ownListener;
    private ImageloaderListener listener;
    private ProgressBar progressBar;
    private ImageView imageView;
    private Context context;
    private String imageUrl;
    //default image size 300 pixel
    private int targetWidth = 300;
    private int targetHeight = 300;

    //constructor
    public ImageLoader(Context context) {
        this.context = context;
    }

    public void load() {
        this.ownListener = this;
        if (imageView != null && progressBar != null) {
            imageView.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }
        //you can change this dynamically
        //http://square.github.io/picasso/
        Picasso.with(context).load(imageUrl).resize(targetWidth, targetHeight).centerCrop()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        ownListener.onSuccess();
                    }

                    @Override
                    public void onError() {
                        ownListener.onError();
                    }
                });
        //http://inthecheesefactory.com/blog/get-to-know-glide-recommended-by-google/en
//        Glide.with(context)
//                .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
//                .into(imageView);
//        Glide.with(context)
//                .load(imageUrl)
//                .listener(new RequestListener<String, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                        ownListener.onError();
//                        return false;
//                    }
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                        ownListener.onSuccess();
//                        return false;
//                    }
//                }).centerCrop().override(targetWidth, targetHeight).into(imageView);
    }

    //set value
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public void setListener(ImageloaderListener listener) {
        this.listener = listener;
    }

    public void setTargetWidth(int targetWidth) {
        this.targetWidth = targetWidth;
    }

    public void setTargetHeight(int targetHeight) {
        this.targetHeight = targetHeight;
    }

    public void setSize(int targetWidth, int targetHeight) {
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
    }

    //listener for callback
    @Override
    public void onSuccess() {
        if (listener != null) listener.onSuccess();
        if (imageView != null && progressBar != null) {
            imageView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onError() {
        if (listener != null) listener.onError();
        if (imageView != null) imageView.setVisibility(View.VISIBLE);
    }
}
