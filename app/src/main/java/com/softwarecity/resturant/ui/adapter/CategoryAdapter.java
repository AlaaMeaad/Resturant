package com.softwarecity.resturant.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.softwarecity.resturant.R;
import com.softwarecity.resturant.dataSource.model.category.Categorylist;
import com.softwarecity.resturant.databinding.CategoryItemBinding;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Activity activity;
    private Context context;
    private List<Categorylist> category = new ArrayList<>();
    private CategoryAdapterListener mCategoryAdapterListener;

        public CategoryAdapter(Activity activity) {
            this.activity = activity;
            this.context = context;
            this.mCategoryAdapterListener = mCategoryAdapterListener;
            this.category = category;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            CategoryItemBinding binding = DataBindingUtil.bind(parent);
            return new ViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.bind(category.get(position));
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
            private CategoryItemBinding binding;

            public ViewHolder(CategoryItemBinding binding) {
                super(binding.getRoot());
                this.binding = binding;

            }

            public void bind(Categorylist categorylist) {
                binding.tvCategoryName.setText(categorylist.getName());
                binding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        }

        public interface CategoryAdapterListener {
            void onClickItem(int position, String property_id);
        }
    }
