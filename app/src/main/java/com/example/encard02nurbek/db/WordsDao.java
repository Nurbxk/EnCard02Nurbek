package com.example.encard02nurbek.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.encard02nurbek.data.model.RoomModel.CategoryModel;
import com.example.encard02nurbek.data.model.RoomModel.WordsModel;

import java.util.List;
@Dao
public interface WordsDao {
    @Query("SELECT * FROM wordsmodel")
    LiveData<List<WordsModel>> getWord();

    @Insert
    void addWord(WordsModel model);
}
