package com.example.encard02nurbek.ui.fragment.categoryFragment;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.encard02nurbek.data.model.RoomModel.CategoryModel;
import com.example.encard02nurbek.databinding.CategoryItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private CategoryItemBinding binding;
    private List<CategoryModel> list = new ArrayList<>();
    private ClickableCard listener;

    public CategoryAdapter(ClickableCard listener) {
        this.listener = listener;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setList(List<CategoryModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.onBind(list.get(position));
        holder.itemView.setOnClickListener(v -> {
            listener.listener(list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        CategoryItemBinding binding;

        public CategoryViewHolder(@NonNull CategoryItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(CategoryModel model) {
            binding.tvItemCategory.setText(model.getCategory());
        }
    }
    interface ClickableCard{
        void listener(CategoryModel model);
    }
}
