package com.dawn.community.viewmodel.fragment.social;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.dawn.community.bean.User;
import com.dawn.community.bean.message.ContactsItem;
import com.dawn.community.repository.ContactsRepository;

import java.util.ArrayList;

/**
 * @author Algorithm
 */
public class ContactsViewModel extends ViewModel {

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    //转化成可公开的数据，只要userMutableLiveData数据一遍，例如执行了下面的setUser函数，就会调用下面重写的apply函数，去仓库获取数据
    public LiveData<ArrayList<ContactsItem>> contactsItems = Transformations.switchMap(userMutableLiveData,
            new Function<User, LiveData<ArrayList<ContactsItem>>>() {
                @Override
                public LiveData<ArrayList<ContactsItem>> apply(User input) {
                    System.out.println("userMutableLiveData is change");
                    return ContactsRepository.getContactsItem(input.getId());
                }
            });

    public void setUser(User user){
        userMutableLiveData.setValue(user);
    }


}
