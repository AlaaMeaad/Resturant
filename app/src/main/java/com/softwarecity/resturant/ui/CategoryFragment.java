package com.softwarecity.resturant.ui;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwarecity.resturant.R;
import com.softwarecity.resturant.databinding.FragmentCategoryBinding;
import com.softwarecity.resturant.ui.viewModel.ViewModelCategory;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
private FragmentCategoryBinding fragmentCategoryBinding;
ViewModelCategory viewModelCategory;
View view;
    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewModelCategory = ViewModelProviders.of(getActivity()).get(ViewModelCategory.class);
        fragmentCategoryBinding = DataBindingUtil.setContentView(getActivity() , R.layout.fragment_category);
        return view;
    }


    private void categoryRecyclerView (){
        fragmentCategoryBinding.rvCategory.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}
