package com.example.encard02nurbek.ui.fragment.onBoard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;

import com.example.encard02nurbek.R;
import com.example.encard02nurbek.base.BaseFragment;
import com.example.encard02nurbek.databinding.FragmentOnBoardBinding;

public class OnBoardFragment extends BaseFragment<FragmentOnBoardBinding>
        implements OnBoardAdapter.Clickable {
    @Override
    protected FragmentOnBoardBinding bind() {
        return FragmentOnBoardBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void setupUI() {
        OnBoardAdapter adapter = new OnBoardAdapter(this);
        binding.boardPager.setAdapter(adapter);
        binding.wormDotsIndicator.setViewPager2(binding.boardPager);
    }

    @Override
    protected void setupObservers() {

    }

    @Override
    public void listener() {
        controller.navigate(R.id.categoryFragment);
    }
}