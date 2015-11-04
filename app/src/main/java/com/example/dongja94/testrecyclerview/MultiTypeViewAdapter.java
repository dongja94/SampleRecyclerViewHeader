package com.example.dongja94.testrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dongja94 on 2015-11-04.
 */
public class MultiTypeViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView;
        }

        public void setText(String text) {
            textView.setText(text);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView;
        }

        public void setText(String text) {
            textView.setText(text);
        }
    }

    public static final int VIEW_TYPE_HEADER = 0;
    public static final int VIEW_TYPE_ITEM = 1;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_HEADER;
        }
        return VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_HEADER :
                View headerView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, null);
                return new HeaderViewHolder(headerView);
            case VIEW_TYPE_ITEM :
                View itemView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, null);
                return new ItemViewHolder(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch(getItemViewType(position)) {
            case VIEW_TYPE_HEADER :
                HeaderViewHolder headerViewHolder = (HeaderViewHolder)holder;
                headerViewHolder.setText("header");
                break;
            case VIEW_TYPE_ITEM :
                ItemViewHolder itemViewHolder = (ItemViewHolder)holder;
                itemViewHolder.setText("item");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
