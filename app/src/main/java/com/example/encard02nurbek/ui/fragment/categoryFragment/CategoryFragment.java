package com.example.encard02nurbek.ui.fragment.categoryFragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.encard02nurbek.R;
import com.example.encard02nurbek.base.BaseFragment;
import com.example.encard02nurbek.data.model.RoomModel.CategoryModel;
import com.example.encard02nurbek.databinding.FragmentCategoryBinding;
import com.example.encard02nurbek.ui.fragment.addCategory.AddCategoryFragmentDialog;

import java.util.List;

public class CategoryFragment extends BaseFragment<FragmentCategoryBinding> implements CategoryAdapter.ClickableCard {
    private CategoryViewModel viewModel;
    private CategoryAdapter adapter;

    @Override
    protected FragmentCategoryBinding bind() {
        return FragmentCategoryBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        openDialog();
    }

    private void openDialog() {
        binding.btnAddCategory.setOnClickListener(v -> {
            new AddCategoryFragmentDialog().show(requireActivity().getSupportFragmentManager(), "");
        });
    }

    @Override
    protected void setupUI() {
        adapter = new CategoryAdapter(this);
        binding.rvCategory.setAdapter(adapter);
        viewModel = new ViewModelProvider(requireActivity()).get(CategoryViewModel.class);
    }

    @Override
    protected void setupObservers() {
        viewModel.getCategory();
        viewModel.getListLiveData().observe(getViewLifecycleOwner(), categoryModels -> {
            adapter.setList(categoryModels);
        });
    }

    @Override
    public void listener(CategoryModel model) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("category", model);
        controller.navigate(R.id.fragment_words, bundle);

    }
}