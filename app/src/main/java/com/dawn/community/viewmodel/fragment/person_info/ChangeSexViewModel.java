package com.dawn.community.viewmodel.fragment.person_info;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/**
 * @author Algorithm
 */
public class ChangeSexViewModel extends ViewModel {

    private MutableLiveData<String> sexMutableLiveData = new MutableLiveData<>();

    //转化成可公开的数据，只要userMutableLiveData数据一遍，例如执行了下面的setUser函数，就会调用下面重写的apply函数，去仓库获取数据
    public LiveData<String> chooseSex = Transformations.switchMap(sexMutableLiveData,
            new Function<String, LiveData<String>>() {
                @Override
                public LiveData<String> apply(String input) {
                    System.out.println("sexMutableLiveData is change");
                    return new MutableLiveData<String>(sexMutableLiveData.getValue());
                }
            });

    public void setSex(String sex){
        sexMutableLiveData.setValue(sex);
    }

}
