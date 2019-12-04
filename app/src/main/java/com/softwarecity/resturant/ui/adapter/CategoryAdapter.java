package com.softwarecity.resturant.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softwarecity.resturant.R;
import com.softwarecity.resturant.dataSource.model.category.Categorylist;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Activity activity;
    private Context context;
    private List<Categorylist> category = new ArrayList<>();
    private CategoryAdapterListener mCategoryAdapterListener;

        public CategoryAdapter(Activity activity, Context context, List<Categorylist> notifications,CategoryAdapterListener mCategoryAdapterListener) {
            this.activity = activity;
            this.context = context;
            this.mCategoryAdapterListener = mCategoryAdapterListener;
            this.category = notifications;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            setData(holder, position);
        }

        private void setData(ViewHolder holder, int position) {

            holder.tvNotification_title.setText(category.get(position).getName());
//            holder.notification_description.setText(category.get(position).getCategoryID());
           // HelperMethod.onLoadImageFromUrl(holder.postAdapterIvPostImage, category.get(position).getCategoryImage(), activity);
        }


        @Override
        public int getItemCount() {
            return category.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView tvNotification_title;
            TextView notification_description;
            TextView tvDate;
            private View view;

            public ViewHolder(View itemview) {
                super(itemview);
                view = itemview;
//                tvDate = view.findViewById(R.id.tv_date);
//                tvNotification_title = view.findViewById(R.id.tv_notification_title);
//                notification_description = view.findViewById(R.id.notification_description);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        mNotificationAdapterListener.onClickItem(getAdapterPosition(),
//                                notifications.get(getAdapterPosition()).getPropertyId());
                    }
                });
            }
        }

        public interface CategoryAdapterListener {
            void onClickItem(int position, String property_id);
        }
    }
