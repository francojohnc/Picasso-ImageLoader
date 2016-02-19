# what is [Picasso-ImageLoader](http://square.github.io/picasso)
![alt tag](https://github.com/francojohnc/Picasso-ImageLoader/blob/master/Screenshot_2016-02-19-00-26-16.png)

if you have existing android application, and use image loader function from any kind of liraries such as volley piccaso etc.
then if you wan't to change the library you already use to better library, its to hard, all codes you call from existing library you need to change one by one.
this is the better way to do that, and this is the stucture i use for my many projects.
if you wan't to improve this structure fill free to contribute

##syntax

#####Load Image
 ImageLoader imageLoader = new ImageLoader(this);
 imageLoader.setImageUrl("http://square.github.io/picasso/static/sample.png");
 imageLoader.setImageView(imageView);
 imageLoader.load();
 
#####Load Image with ProgressBar
 ImageLoader imageLoader = new ImageLoader(this);
 imageLoader.setImageUrl("http://square.github.io/picasso/static/sample.png");
 imageLoader.setProgressBar(pb);
 imageLoader.setImageView(imageView);
 imageLoader.load();
 
#####Load Image with Resize
 ImageLoader imageLoader = new ImageLoader(this);
 imageLoader.setImageUrl("http://square.github.io/picasso/static/sample.png");
 imageLoader.setImageView(imageView);
 imageLoader.setSize(800,800);
 imageLoader.load();
 
#####Load Image with Callback Listener
 imageLoader.setListener(your listener);
 
## and this is the core of the structure from ImageLoader class you can change this line of codes dynamically
 
 ```
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
    }
```
