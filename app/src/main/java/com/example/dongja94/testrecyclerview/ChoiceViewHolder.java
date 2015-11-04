package com.example.dongja94.testrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;

/**
 * Created by dongja94 on 2015-11-04.
 */
public class ChoiceViewHolder extends RecyclerView.ViewHolder {
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }
    OnItemClickListener mCheckListener;
    public void setOnItemCheckListener(OnItemClickListener listener) {
        mCheckListener = listener;
    }

    TextView itemView;

    public ChoiceViewHolder(View itemView) {
        super(itemView);
        this.itemView = (TextView)itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckListener != null) {
                    mCheckListener.onItemClick(v, getAdapterPosition());
                }
            }
        });
    }

    public void setText(String text) {
        itemView.setText(text);
    }

    public void setChecked(boolean checked) {
        if (itemView instanceof Checkable) {
            ((Checkable)itemView).setChecked(checked);
        }
    }
}
