package com.example.encard02nurbek.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.encard02nurbek.data.model.RoomModel.CategoryModel;

import java.util.List;

@Dao
public interface CategoryDao {

    @Query("SELECT * FROM categorymodel")
    LiveData<List<CategoryModel>> getCategory();

    @Insert
    void addCategory(CategoryModel model);
}
