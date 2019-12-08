package com.softwarecity.resturant.ui.viewModel;

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
   public MutableLiveData<List<Category>> listMutableLiveDataCategory = new MutableLiveData<>();

    public void getCategory(){
        apiService.getCategory().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                listMutableLiveDataCategory.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });
    }
}
