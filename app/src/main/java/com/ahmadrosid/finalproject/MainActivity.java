package com.ahmadrosid.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ahmadrosid.finalproject.adapter.AdapterDiscoverMovie;
import com.ahmadrosid.finalproject.api.Api;
import com.ahmadrosid.finalproject.api.ResponseDiscover;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RecyclerView list_movie;
    private AdapterDiscoverMovie adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list_movie = (RecyclerView) findViewById(R.id.list_movie);
        list_movie.setLayoutManager(new GridLayoutManager(this, 2));

        Api.discover(new Api.Result() {
            @Override public void onSuccess(String response) {
                Gson gson = new Gson();
                ResponseDiscover responseDiscover = gson.fromJson(response, ResponseDiscover.class);
                adapter = new AdapterDiscoverMovie(responseDiscover.getResults());
                list_movie.setAdapter(adapter);
            }

            @Override public void onError(Throwable throwable) {
                Log.e(TAG, "onError: ", throwable);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
