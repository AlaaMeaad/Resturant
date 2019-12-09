package com.softwarecity.resturant.ui.viewModel;

import android.app.Activity;
import android.widget.Toast;

import com.softwarecity.resturant.dataSource.ApiService;
import com.softwarecity.resturant.dataSource.model.category.Category;
import com.softwarecity.resturant.dataSource.model.category.Categorylist;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelCategory extends ViewModel {
ApiService apiService;
   public MutableLiveData<List<Categorylist>> listMutableLiveDataCategory = new MutableLiveData<>();

    public void getCategory(){
        apiService.getCategory().enqueue(new Callback<List<Categorylist>>() {
            @Override
            public void onResponse(Call<List<Categorylist>> call, Response<List<Categorylist>> response) {
                listMutableLiveDataCategory.setValue(response.body());
//                Toast.makeText(getCategory() , "hhhh",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Categorylist>> call, Throwable t) {

            }
        });
    }
}
