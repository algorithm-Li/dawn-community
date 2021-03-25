package com.dawn.community.fragment.social;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentContactsBinding;
import com.dawn.community.viewmodel.fragment.social.ContactsViewModel;

public class ContactsFragment extends BaseVmFragment<FragmentContactsBinding, ContactsViewModel> {

    private static final String TAG = "ContactsFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<ContactsViewModel> getSubVMClass() {
        return ContactsViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_contacts;
    }
}
