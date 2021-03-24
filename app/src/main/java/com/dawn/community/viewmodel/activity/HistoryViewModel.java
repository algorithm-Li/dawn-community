package com.dawn.community.viewmodel.activity;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.dawn.community.bean.history.HistoryItem;
import com.dawn.community.bean.history.User;
import com.dawn.community.repository.HistoryRepository;

import java.util.ArrayList;

public class HistoryViewModel extends ViewModel {

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    public LiveData<ArrayList<HistoryItem>> historyItemLiveData = Transformations.switchMap(userMutableLiveData,
            new Function<User, LiveData<ArrayList<HistoryItem>>>() {
        @Override
        public LiveData<ArrayList<HistoryItem>> apply(User input) {
            return HistoryRepository.getWatchHistory(input.getId());
        }
    });

    public void setUser(User user){
        userMutableLiveData.setValue(user);
    }
}
