package com.example.encard02nurbek.ui.fragment.wordsFragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.encard02nurbek.common.Resourse;
import com.example.encard02nurbek.data.model.RoomModel.WordsModel;
import com.example.encard02nurbek.data.model.pixabayModel.PixabayResponce;
import com.example.encard02nurbek.db.WordsDao;
import com.example.encard02nurbek.repository.pixabay.PixabayRepository;


import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class WordsViewModel extends ViewModel {
    private PixabayRepository repository;
    private WordsDao dao;
    private LiveData<Resourse<PixabayResponce>> liveData;
    private LiveData<List<WordsModel>> liveDataRoom;

    @Inject
    public WordsViewModel(PixabayRepository repository, WordsDao dao) {
        this.repository = repository;
        this.dao = dao;
        liveData = new MutableLiveData<>();
        liveDataRoom = new MutableLiveData<>();

    }

    public LiveData<List<WordsModel>> getRoomImg() {
        return liveDataRoom = dao.getWord();
    }

    public void getImage(String word) {
        liveData = repository.getImage(word);
    }

    public LiveData<Resourse<PixabayResponce>> getLiveData() {
        return liveData;
    }
}
