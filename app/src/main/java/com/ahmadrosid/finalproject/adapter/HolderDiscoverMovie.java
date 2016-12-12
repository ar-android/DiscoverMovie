package com.ahmadrosid.finalproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.finalproject.R;
import com.ahmadrosid.finalproject.api.ResponseDiscover;
import com.bumptech.glide.Glide;

import static com.ahmadrosid.finalproject.api.Endpoint.URL_IMAGE_500;

/**
 * Created by ocittwo on 12/11/16.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class HolderDiscoverMovie extends RecyclerView.ViewHolder{

    private ImageView image;
    private TextView title;

    public HolderDiscoverMovie(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.image_movie);
        title = (TextView) itemView.findViewById(R.id.title_movie);
    }

    public void bind(ResponseDiscover.ResultsBean data) {
        String url_image = URL_IMAGE_500 + data.getPoster_path();
        Glide.with(itemView.getContext())
                .load(url_image)
                .into(image);
        title.setText(data.getTitle());
    }
}
