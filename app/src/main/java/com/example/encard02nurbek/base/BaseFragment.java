package com.example.encard02nurbek.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

import com.example.encard02nurbek.R;

public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {
    protected VB binding;
    protected NavController controller;
    protected abstract VB bind();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = bind();
        controller = Navigation.findNavController(requireActivity(), R.id.nav_host);
        setupUI();
        setupObservers();
        return binding.getRoot();
    }

    protected abstract void setupUI();
    protected abstract void setupObservers();
}
