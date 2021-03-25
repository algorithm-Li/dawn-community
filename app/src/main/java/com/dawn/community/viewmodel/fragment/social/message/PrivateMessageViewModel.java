package com.dawn.community.viewmodel.fragment.social.message;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.dawn.community.bean.history.User;
import com.dawn.community.bean.message.PrivateMessageItem;
import com.dawn.community.repository.PrivateMessageRepository;

import java.util.ArrayList;

public class PrivateMessageViewModel extends ViewModel {

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    public LiveData<ArrayList<PrivateMessageItem>> privateMessageItems = Transformations.switchMap(userMutableLiveData,
            new Function<User, LiveData<ArrayList<PrivateMessageItem>>>() {
                @Override
                public LiveData<ArrayList<PrivateMessageItem>> apply(User input) {
                    System.out.println("userMutableLiveData is change");
                    return PrivateMessageRepository.getPrivateMessage(input.getId());
                }
            });

    public void setUser(User user){
        userMutableLiveData.setValue(user);
    }

}
