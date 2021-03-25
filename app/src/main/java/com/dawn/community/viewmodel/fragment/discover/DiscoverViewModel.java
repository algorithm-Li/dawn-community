package com.dawn.community.viewmodel.fragment.discover;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import com.dawn.community.bean.tabs.DiscoverTab;

/**
 * @author Algorithm
 */
public class DiscoverViewModel extends ViewModel {

    public final ObservableField<Fragment> fragment = new ObservableField<>();
    public final ObservableField<DiscoverTab> tabConfig = new ObservableField<>();
    public final ObservableBoolean destroy = new ObservableBoolean();
    public final ObservableInt type = new ObservableInt();

    {
        destroy.set(false);
    }
}
