package com.softwarecity.resturant.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwarecity.resturant.R;
import com.softwarecity.resturant.ui.viewModel.ViewModelCategory;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    ViewModelCategory viewModelCategory;
    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewModelCategory = ViewModelProviders.of(getActivity()).get(ViewModelCategory.class);
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

}
