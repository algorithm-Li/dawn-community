package com.dawn.community.viewmodel.fagment.discover;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import com.dawn.community.bean.tabs.SocialTab;

public class SocialViewModel extends ViewModel {

    public final ObservableField<Fragment> fragment = new ObservableField<>();
    public final ObservableField<SocialTab> tabConfig = new ObservableField<>();
    public final ObservableBoolean destroy = new ObservableBoolean();
    public final ObservableInt type = new ObservableInt();

    {
        destroy.set(false);
    }

}
