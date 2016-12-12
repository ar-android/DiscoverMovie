package com.ahmadrosid.finalproject.ui.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.finalproject.R;
import com.ahmadrosid.finalproject.api.Api;
import com.ahmadrosid.finalproject.api.Endpoint;
import com.ahmadrosid.finalproject.api.ResponseDiscover;
import com.ahmadrosid.finalproject.api.ResponseVideos;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;


/**
 * Created by ocittwo on 12/12/16.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class DetailMovieFragment extends Fragment {

    private static final String TAG = "DetailMovieFragment";

    private ResponseDiscover.ResultsBean data;

    private ImageView img_banner;
    private ImageView img_play;
    private ImageView img_poster;
    private TextView title;
    private TextView date;
    private TextView rating;
    private TextView overview;

    public DetailMovieFragment(ResponseDiscover.ResultsBean data) {
        this.data = data;
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_movie, container, false);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img_play = (ImageView) view.findViewById(R.id.img_play);
        img_banner = (ImageView) view.findViewById(R.id.img_banner);
        img_poster = (ImageView) view.findViewById(R.id.img_poster);
        title = (TextView) view.findViewById(R.id.title);
        date = (TextView) view.findViewById(R.id.date);
        rating = (TextView) view.findViewById(R.id.rating);
        overview = (TextView) view.findViewById(R.id.overview);
        setView();
    }

    private void setView() {
        Glide.with(this)
                .load(Endpoint.URL_IMAGE_500 + data.getPoster_path())
                .centerCrop()
                .into(img_banner);
        Glide.with(this)
                .load(Endpoint.URL_IMAGE_300 + data.getPoster_path())
                .into(img_poster);
        title.setText(data.getTitle());
        date.setText(data.getRelease_date());
        rating.setText("" + data.getPopularity());
        overview.setText(data.getOverview());

        img_play.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                getVideo();
            }
        });
    }

    public void getVideo() {
        Api.videos(String.valueOf(data.getId()), new Api.Result() {
            @Override public void onSuccess(final String response) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override public void run() {
                        handleResponse(response);
                    }
                });
            }

            @Override public void onError(Throwable throwable) {
                Log.e(TAG, "onError: ", throwable);
            }
        });
    }

    private void handleResponse(String response) {
        Log.d(TAG, "handleResponse: " + response);
        Gson gson = new Gson();
        ResponseVideos responseVideos = gson.fromJson(response, ResponseVideos.class);
        watchYoutubeVideo(responseVideos.getResults().get(0).getKey());
    }

    public void watchYoutubeVideo(String id) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
}
