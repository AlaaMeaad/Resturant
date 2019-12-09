package com.softwarecity.resturant.ui;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.softwarecity.resturant.R;
import com.softwarecity.resturant.dataSource.model.category.Category;
import com.softwarecity.resturant.dataSource.model.category.Categorylist;
import com.softwarecity.resturant.databinding.FragmentCategoryBinding;
import com.softwarecity.resturant.ui.adapter.CategoryAdapter;
import com.softwarecity.resturant.ui.viewModel.ViewModelCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    private FragmentCategoryBinding fragmentCategoryBinding;
    ViewModelCategory viewModelCategory;
    CategoryAdapter categoryAdapter;
    View view;
    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewModelCategory = ViewModelProviders.of(getActivity()).get(ViewModelCategory.class);
        fragmentCategoryBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_category , container , false);
//        view = fragmentCategoryBinding.getRoot();
//        fragmentCategoryBinding = DataBindingUtil.setContentView(getActivity() , R.layout.fragment_category);
        categoryRecyclerView ();
      //  Toast.makeText(getActivity() , "yarb" , Toast.LENGTH_SHORT).show();
        return view;
    }



    private void categoryRecyclerView (){
        fragmentCategoryBinding.rvCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        categoryAdapter = new CategoryAdapter(getActivity());
        fragmentCategoryBinding.rvCategory.setAdapter(categoryAdapter);

        viewModelCategory.listMutableLiveDataCategory.observe(this, new Observer<List<Categorylist>>() {
            @Override
            public void onChanged(List<Categorylist> categories) {
                List<Categorylist> mylist = new ArrayList<>() ;

//                Toast.makeText(getContext() , "ddd" , Toast.LENGTH_SHORT).show();

            }
        });
    }
}
