package com.acryink.android_example;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.acryink.android_example.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityHandler {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setHandler(this);
    }

    @Override
    public void onBaseButtonClick(View view) {
        List<String> values = new ArrayList<>();
        values.add(String.valueOf("One"));
        values.add(String.valueOf("Two"));
        values.add(String.valueOf("Three"));
        values.add(String.valueOf("Four"));
        values.add(String.valueOf("Five"));
        binding.recyclerView.setItems(values);
    }

    @Override
    public void onLowButtonClick(View view) {
        List<String> values = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            values.add(String.valueOf(i + 1));
        }
        binding.recyclerView.setItems(values);
    }

    @Override
    public void onMaxButtonClick(View view) {
        List<String> values = new ArrayList<>();
        for (int i = 100; i > 0; i--) {
            values.add(String.valueOf(i));
        }
        binding.recyclerView.setItems(values);
    }
}
