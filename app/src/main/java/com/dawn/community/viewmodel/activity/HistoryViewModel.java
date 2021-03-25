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

/**
 * @author Algorithm
 */
public class HistoryViewModel extends ViewModel {

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    //转化成可公开的数据，只要userMutableLiveData数据一遍，例如执行了下面的setUser函数，就会调用下面重写的apply函数，去仓库获取数据
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
