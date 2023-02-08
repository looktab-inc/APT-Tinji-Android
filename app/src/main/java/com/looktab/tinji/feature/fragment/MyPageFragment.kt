package com.looktab.tinji.feature.fragment

import android.content.Context
import androidx.fragment.app.activityViewModels
import com.looktab.tinji.R
import com.looktab.tinji.base.BaseFragment
import com.looktab.tinji.databinding.FragmentMypageBinding
import com.looktab.tinji.feature.MainViewModel
import com.looktab.tinji.feature.fragment.adapter.HistoryCardAdapter
import com.looktab.tinji.feature.model.History

class MyPageFragment : BaseFragment<FragmentMypageBinding>(
    R.layout.fragment_mypage
) {

    private val activityViewModel: MainViewModel by activityViewModels()
    lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context;
    }

    override fun initViews() {
        binding.viewModel = activityViewModel
        initRecyclerView()
    }

    private fun initRecyclerView() {
        activityViewModel.setReviewHistory(false)
    }

    override fun initObserves() {
        activityViewModel.reviewHistory.observe(this) {

        }
    }

    companion object {
        fun newInstance() = MyPageFragment()
    }


}