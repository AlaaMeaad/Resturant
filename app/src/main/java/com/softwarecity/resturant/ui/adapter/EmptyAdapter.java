package com.softwarecity.resturant.ui.adapter;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwarecity.resturant.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class EmptyAdapter extends RecyclerView.Adapter<EmptyAdapter.ViewHolder> {
    private Context context;
    private Activity activity;

    @Override
    public EmptyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item,
                parent, false);

        return new EmptyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmptyAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(EmptyAdapter.ViewHolder holder, int position) {

    }

    private void setAction(EmptyAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
//            ButterKnife.bind(this, view);
        }
    }
}
