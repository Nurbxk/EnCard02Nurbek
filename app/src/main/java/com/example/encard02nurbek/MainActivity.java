package com.example.encard02nurbek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.example.encard02nurbek.databinding.ActivityMainBinding;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NavHostFragment navHostFragment;
    private NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initNavView();
    }

    private void initNavView() {
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host);
        controller = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.navView, controller);
        controller.addOnDestinationChangedListener((controller, destination, arguments) -> {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(R.id.categoryFragment);
            if (list.contains(destination.getId())) {
                binding.navView.setVisibility(View.VISIBLE);
            } else {
                binding.navView.setVisibility(View.GONE);
            }
        });
    }
}

