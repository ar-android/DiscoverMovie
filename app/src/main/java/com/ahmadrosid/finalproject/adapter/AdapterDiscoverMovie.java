package com.ahmadrosid.finalproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmadrosid.finalproject.R;
import com.ahmadrosid.finalproject.api.ResponseDiscover;

import java.util.List;

/**
 * Created by ocittwo on 12/11/16.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class AdapterDiscoverMovie extends RecyclerView.Adapter<HolderDiscoverMovie>{

    private List<ResponseDiscover.ResultsBean> data;
    private OnItemClickListener clickListener;

    public AdapterDiscoverMovie(List<ResponseDiscover.ResultsBean> data, OnItemClickListener clickListener) {
        this.data = data;
        this.clickListener = clickListener;
    }

    @Override public HolderDiscoverMovie onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_dicover_movie, parent, false);
        return new HolderDiscoverMovie(view);
    }

    @Override public void onBindViewHolder(HolderDiscoverMovie holder, final int position) {
        holder.bind(data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                clickListener.onClick(data.get(position));
            }
        });
    }

    @Override public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener{
        void onClick(ResponseDiscover.ResultsBean resultsBean);
    }
}
