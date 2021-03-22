package com.dawn.community.fragment.social;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentContactsBinding;
import com.dawn.community.viewmodel.fagment.discover.ContactsViewModel;

public class ContactsFragment extends BaseVmFragment<FragmentContactsBinding, ContactsViewModel> {

    @Override
    public Class<ContactsViewModel> getSubVMClass() {
        return ContactsViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_contacts;
    }
}
