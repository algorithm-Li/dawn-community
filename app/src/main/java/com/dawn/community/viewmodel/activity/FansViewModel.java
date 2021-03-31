package com.dawn.community.viewmodel.activity;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.dawn.community.bean.FansItem;
import com.dawn.community.bean.User;
import com.dawn.community.bean.message.Message;
import com.dawn.community.repository.ChatRepository;
import com.dawn.community.repository.FansRepository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Algorithm
 * @Date: 2021/3/31/0031
 * @Time: 13:52
 */
public class FansViewModel extends ViewModel {

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    //转化成可公开的数据，只要userMutableLiveData数据一遍，例如执行了下面的setUser函数，就会调用下面重写的apply函数，去仓库获取数据
    public LiveData<ArrayList<FansItem>> fansItems = Transformations.switchMap(userMutableLiveData,
            new Function<User, LiveData<ArrayList<FansItem>>>() {
                @Override
                public LiveData<ArrayList<FansItem>> apply(User input) {
                    return FansRepository.getFansItem(input.getId());
                }
            });

    public void setUser(User user){
        userMutableLiveData.setValue(user);
    }

}
