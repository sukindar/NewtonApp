package com.dirakit.newtonapp;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Feed> dataTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        final SwipeRefreshLayout dorefresh = (SwipeRefreshLayout)findViewById(R.id.refresh);
        dorefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItem();
                Toast.makeText(MainActivity.this,"Data Diperbarui",Toast.LENGTH_LONG).show();
            }
            private void refreshItem() {
                initViews();
                onItemLoad();
            }

            private void onItemLoad() {
                dorefresh.setRefreshing(false);
            }
        });
    }

    private void initViews() {
        recyclerView = (RecyclerView)findViewById(R.id.cardrecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {

        String appkey = getResources().getString(R.string.api_key);
        String url = getResources().getString(R.string.base_url);
        String result = getResources().getString(R.string.result_entries);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewtonClient request = retrofit.create(NewtonClient.class);
        Call<Data> call = request.getData(appkey,result);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                dataTime = response.body().getFeeds();
                recyclerView.setAdapter(new DataAdapter(dataTime, R.layout.list_item, this));
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Gagal Mendapatkan Data", Toast.LENGTH_LONG).show();
            }
        });
    }
}
