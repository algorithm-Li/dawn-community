package com.dawn.community.viewmodel.fragment.discover;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.dawn.community.bean.discover.RecommendItem;
import com.dawn.community.bean.User;
import com.dawn.community.repository.RecommendRepository;

import java.util.ArrayList;

/**
 * @author Algorithm
 */
public class RecommendViewModel extends ViewModel {

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    //转化成可公开的数据，只要userMutableLiveData数据一遍，例如执行了下面的setUser函数，就会调用下面重写的apply函数，去仓库获取数据
    public LiveData<ArrayList<RecommendItem>> recommendItems = Transformations.switchMap(userMutableLiveData,
            new Function<User, LiveData<ArrayList<RecommendItem>>>() {
                @Override
                public LiveData<ArrayList<RecommendItem>> apply(User input) {
                    System.out.println("userMutableLiveData is change");
                    return RecommendRepository.getHot();
                }
            });

    public void setUser(User user){
        userMutableLiveData.setValue(user);
    }

}
