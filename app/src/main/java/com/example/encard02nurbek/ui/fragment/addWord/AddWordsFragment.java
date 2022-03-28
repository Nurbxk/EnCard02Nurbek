package com.example.encard02nurbek.ui.fragment.addWord;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.encard02nurbek.R;
import com.example.encard02nurbek.base.BaseBottomSheetFragment;
import com.example.encard02nurbek.common.ISendKeyWord;
import com.example.encard02nurbek.databinding.FragmentAddWordsBinding;

public class AddWordsFragment extends BaseBottomSheetFragment<FragmentAddWordsBinding> {
    private ISendKeyWord keyWord;

    @Override
    protected FragmentAddWordsBinding bind() {
        return FragmentAddWordsBinding.inflate(getLayoutInflater());
    }

    public AddWordsFragment(ISendKeyWord keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    private void initListener() {
        binding.etCategory.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = binding.etCategory.getText().length();
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    String word = binding.etCategory.getText().toString();
                    if (length == word.length()) {
                        controller.navigate(R.id.fragment_words);
                        keyWord.send(word);
                        dismiss();
                    }
                }, 2000);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void setupUI() {

    }

    @Override
    protected void setupObservers() {

    }
}