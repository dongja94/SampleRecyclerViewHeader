package com.example.dongja94.testrecyclerview;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongja94 on 2015-11-04.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView;
        }

        public void setText(String text) {
            textView.setText(text);
        }

        public void setTextSize(float size) {
            textView.setTextSize(size);
        }
    }

    List<String> items = new ArrayList<String>();

    public void add(String item) {
        items.add(item);
        notifyDataSetChanged();
    }

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 1;

    @Override
    public int getItemViewType(int position) {
        if (position % 6 == 0) {
            return VIEW_TYPE_HEADER;
        }
        return VIEW_TYPE_ITEM;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, null);
        switch (viewType) {
            case VIEW_TYPE_HEADER : {
                view.setBackgroundColor(Color.RED);
                StaggeredGridLayoutManager.LayoutParams params = new StaggeredGridLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setFullSpan(true);
                view.setLayoutParams(params);
                break;
            }
            case VIEW_TYPE_ITEM : {
            }
        }
        return new ViewHolder(view);
    }

    static float[] FONT_SIZE = {20, 30, 40};

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_HEADER :
                holder.setText("Header Text............................");
                holder.setTextSize(30);
                break;
            case VIEW_TYPE_ITEM :
                holder.setText(items.get(position));
                holder.setTextSize(FONT_SIZE[position % FONT_SIZE.length]);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
