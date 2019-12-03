package com.softwarecity.resturant.ui.viewModel;

import com.softwarecity.resturant.dataSource.model.category.Category;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelCategory extends ViewModel {

    MutableLiveData<List<Category>> listMutableLiveDataCategory = new MutableLiveData<>();

}
