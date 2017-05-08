package com.dirakit.newtonapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import retrofit2.Callback;


/**
 * Created by sukin on 5/3/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private final List<Feed> feeds;

    public DataAdapter(List<Feed> feeds, int list_item, Callback<Data> callback){
        this.feeds = feeds;
    }


    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder (view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int position) {
        viewHolder.textView.setText("t1 = " + feeds.get(position).getField1());
        viewHolder.textView2.setText("t2 = " + feeds.get(position).getField2());
        viewHolder.textView3.setText("t3 = " + feeds.get(position).getField3());
        viewHolder.textView4.setText("t4 = " + feeds.get(position).getField4());
        viewHolder.textView5.setText("a  = " + feeds.get(position).getField5());
        viewHolder.noData.setText("Data " + (position+1));
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView, textView2, textView3, textView4, textView5, noData;

        public ViewHolder(View view){
            super(view);

            textView = (TextView) view.findViewById(R.id.TextView);
            textView2 = (TextView) view.findViewById(R.id.TextView2);
            textView3 = (TextView) view.findViewById(R.id.TextView3);
            textView4 = (TextView) view.findViewById(R.id.TextView4);
            textView5 = (TextView) view.findViewById(R.id.TextView5);
            noData = (TextView)view.findViewById(R.id.NoData);

        }
    }
}
