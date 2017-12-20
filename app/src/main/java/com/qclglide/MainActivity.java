package com.qclglide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private ImageView image2;
    private ImageView image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);

        String images1 = "http://seopic.699pic.com/photo/40007/2702.jpg_wh1200.jpg" ;
        String images2 = "http://seopic.699pic.com/photo/40006/8569.jpg_wh1200.jpg";



        Glide.with(this)
                .load(images1)
                .animate(R.anim.zoom_in) // or R.anim.zoom_in
                .error(R.mipmap.ic_launcher)
                .into(image);
        //        Glide.with(this)
        //                .load(images2)
        //                .skipMemoryCache(true)//禁止内存缓存：
        //                .animate(R.anim.zoom_in) // or R.anim.zoom_in
        //                .into(image2);
        //圆形裁剪
        Glide.with(this)
                .load(images2)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(image2);
        // //圆角处理
        Glide.with(this)
                .load(images2)
                //                .bitmapTransform(new GrayscaleTransformation(this))//带灰色蒙层
                .bitmapTransform(new RoundedCornersTransformation(this, 30, 0, RoundedCornersTransformation.CornerType.ALL))
                .into(image3);
    }
}
