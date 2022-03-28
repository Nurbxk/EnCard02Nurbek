package com.example.encard02nurbek.ui.fragment.onBoard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.encard02nurbek.R;
import com.example.encard02nurbek.databinding.PageBoardBinding;

public class OnBoardAdapter extends RecyclerView.Adapter<OnBoardAdapter.BoardViewHolder> {
    private Clickable listener;
    private PageBoardBinding binding;
    private static final String category = "Категории";
    private static final String personalArea = "Личный Кабинет";
    private static final String letsGo = "Давай начнем!";

    private static final String categoryDes = "Создавайте собственные категории для слов";
    private static final String wordsDes = "Создавайте слова на английском и кликайте " +
            "на карточку чтобы увидеть его перевод и картинку для ассоциации";
    private static final String personalAreaDes = "Следите за своими ачивками " +
            "и количеством очков опыта";

    private final static int[] anim = {R.raw.easytolearn, R.raw.learning, R.raw.onlinelearning};
    private final static String[] titleList = {category, personalArea, letsGo};
    private final static String[] desTitle = {categoryDes, wordsDes, personalAreaDes};

    public OnBoardAdapter(Clickable listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = PageBoardBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new BoardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {
        holder.onBind(position);
        holder.binding.btnBoard.setOnClickListener(v -> {
            listener.listener();
        });
    }

    @Override
    public int getItemCount() {
        return titleList.length;
    }

    public static class BoardViewHolder extends RecyclerView.ViewHolder {
        private final PageBoardBinding binding;

        public BoardViewHolder(@NonNull PageBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void onBind(int position) {
            binding.lottieAnimBoard.setAnimation(anim[position]);
            binding.tvCategoryBoard.setText(titleList[position]);
            binding.tvDescriptionBoard.setText(desTitle[position]);

            if (position == anim.length - 1) {
                binding.btnBoard.setVisibility(View.VISIBLE);
                binding.tvDescriptionBoard.setVisibility(View.GONE);
            } else {
                binding.btnBoard.setVisibility(View.GONE);
            }
        }
    }

    interface Clickable {
        void listener();
    }
}
