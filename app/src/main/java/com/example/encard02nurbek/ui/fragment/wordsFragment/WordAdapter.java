package com.example.encard02nurbek.ui.fragment.wordsFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.encard02nurbek.data.model.RoomModel.WordsModel;
import com.example.encard02nurbek.data.model.pixabayModel.Hit;
import com.example.encard02nurbek.data.model.pixabayModel.PixabayResponce;
import com.example.encard02nurbek.databinding.ItemRvImageBinding;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    private List<WordsModel> list = new ArrayList<>();

    public void setList(List<WordsModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRvImageBinding binding = ItemRvImageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new WordViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder {
        ItemRvImageBinding binding;
        public WordViewHolder(@NonNull ItemRvImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(WordsModel hit) {
            Glide.with(binding.getRoot()).load(hit.getText()).centerCrop().into(binding.itemImage);
            binding.tvItemBoard.setText(hit.getText());
        }
    }
}
