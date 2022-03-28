package com.example.encard02nurbek.ui.fragment.addCategory;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.encard02nurbek.base.BaseBottomSheetFragment;
import com.example.encard02nurbek.data.model.RoomModel.CategoryModel;
import com.example.encard02nurbek.databinding.FragmentAddCategoryDialogBinding;

public class AddCategoryFragmentDialog extends BaseBottomSheetFragment<FragmentAddCategoryDialogBinding> {
    private AddCategoryViewModel viewModel;

    @Override
    protected FragmentAddCategoryDialogBinding bind() {
        return FragmentAddCategoryDialogBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupUI() {
        viewModel = new ViewModelProvider(requireActivity()).get(AddCategoryViewModel.class);
    }

    @Override
    protected void setupObservers() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    private void initListener() {
        binding.btnSaveCategory.setOnClickListener(v -> {
            String category = binding.etCategory.getText().toString();
            viewModel.insert(new CategoryModel(category));
            dismiss();
        });
    }
}