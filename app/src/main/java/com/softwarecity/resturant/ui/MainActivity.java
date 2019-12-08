package com.softwarecity.resturant.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.softwarecity.resturant.R;
import com.softwarecity.resturant.helper.HelperMethod;

import static com.softwarecity.resturant.helper.HelperMethod.ReplaceFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
