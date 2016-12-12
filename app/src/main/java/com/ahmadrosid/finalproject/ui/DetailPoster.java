package com.ahmadrosid.finalproject.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by ocittwo on 12/12/16.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class DetailPoster extends AppCompatActivity{
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView img = new ImageView(this);
        String url = getIntent().getStringExtra("poster");
//        Glide.with(this)
//                .load(url)
//                .centerCrop()
//                .animate()
    }
}
