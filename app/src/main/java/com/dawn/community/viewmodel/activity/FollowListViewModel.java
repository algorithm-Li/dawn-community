package com.dawn.community.viewmodel.activity;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.dawn.community.bean.FansItem;
import com.dawn.community.bean.FollowMessageItem;
import com.dawn.community.bean.User;
import com.dawn.community.repository.FansRepository;
import com.dawn.community.repository.FollowListRepository;

import java.util.ArrayList;

/**
 * @author Algorithm
 * @Date: 2021/3/31/0031
 * @Time: 13:52
 */
public class FollowListViewModel extends ViewModel {

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    //转化成可公开的数据，只要userMutableLiveData数据一遍，例如执行了下面的setUser函数，就会调用下面重写的apply函数，去仓库获取数据
    public LiveData<ArrayList<FollowMessageItem>> followMessageItems = Transformations.switchMap(userMutableLiveData,
            new Function<User, LiveData<ArrayList<FollowMessageItem>>>() {
                @Override
                public LiveData<ArrayList<FollowMessageItem>> apply(User input) {
                    return FollowListRepository.getFollowMessage(input.getId());
                }
            });

    public void setUser(User user){
        userMutableLiveData.setValue(user);
    }

}
