package com.example.dongja94.testrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongja94 on 2015-11-04.
 */
public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceViewHolder> implements ChoiceViewHolder.OnItemClickListener {

    List<String> items = new ArrayList<String>();
    SparseBooleanArray checkedItems = new SparseBooleanArray();

    public void add(String item) {
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public ChoiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_multiple_choice, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        ChoiceViewHolder holder = new ChoiceViewHolder(view);
        holder.setOnItemCheckListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ChoiceViewHolder holder, int position) {
        holder.setText(items.get(position));
        holder.setChecked(checkedItems.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onItemClick(View view, int position) {
        boolean checked = !checkedItems.get(position);
        checkedItems.put(position, checked);
        notifyDataSetChanged();
    }

    public SparseBooleanArray getCheckedItemPositions() {
        return checkedItems;
    }

    public void setItemCheck(int position, boolean check) {
        checkedItems.put(position, check);
        notifyDataSetChanged();
    }
}
