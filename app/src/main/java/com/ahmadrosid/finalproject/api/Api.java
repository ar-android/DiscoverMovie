package com.ahmadrosid.finalproject.api;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ocittwo on 12/11/16.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class Api {
    private static final OkHttpClient client = new OkHttpClient();

    public interface Result{
        void onSuccess(String response);
        void onError(Throwable throwable);
    }

    public static void discover(final Result result){
        Request request = new Request.Builder()
                .url(Endpoint.DISCOVER)
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                result.onError(e);
            }

            @Override public void onResponse(Call call, Response response)
                    throws IOException {
                result.onSuccess(response.body().string());
            }
        });
    }

    public static void videos(String id, final Result result){
        Request request = new Request.Builder()
                .url(Endpoint.VIDIO(id))
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                result.onError(e);
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                result.onSuccess(response.body().string());
            }
        });
    }
}
