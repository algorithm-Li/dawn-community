package com.dawn.community.fragment.social.message;

import android.util.Log;

import com.dawn.community.R;
import com.dawn.community.base.BaseVmFragment;
import com.dawn.community.databinding.FragmentCommentBinding;
import com.dawn.community.viewmodel.fragment.social.message.CommentViewModel;

/**
 * @author Algorithm
 */
public class CommentFragment extends BaseVmFragment<FragmentCommentBinding, CommentViewModel> {

    private static final String TAG = "CommentFragment";

    @Override
    protected void initView() {
        super.initView();
        Log.d(TAG,"==> initView");
    }

    @Override
    public Class<CommentViewModel> getSubVMClass() {
        return CommentViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_comment;
    }
}
