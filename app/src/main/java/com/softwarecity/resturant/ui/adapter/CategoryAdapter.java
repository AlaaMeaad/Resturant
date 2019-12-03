package com.softwarecity.resturant.ui.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.softwarecity.resturant.BuildConfig;
import com.softwarecity.resturant.R;
import com.softwarecity.resturant.dataSource.model.category.Category;
import com.softwarecity.resturant.helper.HelperMethod;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {


    private Activity activity;
    private Context context;
    private List<Category> mData = new ArrayList<>();
    private PropertyAdapterListener mPropertyAdapterListener;

    public CategoryAdapter(Activity activity, Context context, List<Category> mData, PropertyAdapterListener mPropertyAdapterListener) {
        this.activity = activity;
        this.context = context;
        this.mPropertyAdapterListener = mPropertyAdapterListener;
        this.mData = mData;
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

    @SuppressLint("SetTextI18n")
    private void setData(ViewHolder holder, int position) {
//        holder.tvBathroomsValue.setText(mData.get(position).getBathrooms() + " " + activity.getResources().getString(R.string.bathrooms_value));
//        holder.tvRoomsValue.setText(mData.get(position).getRooms() + " " + activity.getResources().getString(R.string.rooms_value));
//        holder.tvPriceValue.setText(mData.get(position).getPrice() + " " + activity.getResources().getString(R.string.le));
//        holder.tvTypeValue.setText(mData.get(position).getType() + " - " + mData.get(position).getPurpose());
//        holder.tvName.setText(mData.get(position).getTitle());
//        holder.tvLocationValue.setText(mData.get(position).getCountry() + " - " + mData.get(position).getCity());
//        holder.tvSizeValue.setText(mData.get(position).getSize());
//        if (mData.get(position).getImg() == null){
//            HelperMethod.onLoadImageFromUrl(holder.ivImage, BuildConfig.BASE_IMAGE_URL + "no_image.jpg", activity);
//        }else {
//            HelperMethod.onLoadImageFromUrl(holder.ivImage, BuildConfig.BASE_IMAGE_URL + mData.get(position).getImg(), activity);
//        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View view;
        ImageView ivImage;
        TextView tvcategoryname;

        public ViewHolder(View itemview) {
            super(itemview);
            view = itemview;
            ivImage = view.findViewById(R.id.iv_image);
            tvcategoryname = view.findViewById(R.id.tv_category_name);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    mPropertyAdapterListener.onClickItem(getAdapterPosition(), mData.get(getAdapterPosition()).getPropertyId());
                }
            });
        }
    }

    public void addAll(List<Category> properties){
        this.addAll(properties);
        notifyDataSetChanged();
    }

    public interface PropertyAdapterListener{
        void onClickItem(int position, String id);
    }
}