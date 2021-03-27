package com.dawn.community.viewmodel.activity;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.dawn.community.bean.User;
import com.dawn.community.bean.message.Message;
import com.dawn.community.repository.ChatRepository;

import java.util.Collection;

/**
 * @author Algorithm
 */
public class ChatViewModel extends ViewModel {

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    //转化成可公开的数据，只要userMutableLiveData数据一遍，例如执行了下面的setUser函数，就会调用下面重写的apply函数，去仓库获取数据
    public LiveData<Collection<Message>> historyItemLiveData = Transformations.switchMap(userMutableLiveData,
            new Function<User, LiveData<Collection<Message>>>() {
                @Override
                public LiveData<Collection<Message>> apply(User input) {
                    return ChatRepository.getContactsItem(input.getId());
                }
            });

    public void setUser(User user){
        userMutableLiveData.setValue(user);
    }

}
