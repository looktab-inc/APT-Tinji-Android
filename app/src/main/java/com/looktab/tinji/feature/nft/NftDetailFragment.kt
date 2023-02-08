package com.looktab.tinji.feature.nft

import android.content.Context
import android.util.Log
import androidx.fragment.app.activityViewModels
import com.looktab.tinji.R
import com.looktab.tinji.base.BaseFragment
import com.looktab.tinji.databinding.FragmentNftBinding
import com.looktab.tinji.databinding.FragmentNftDetailsBinding
import com.looktab.tinji.feature.MainViewModel

class NftDetailFragment : BaseFragment<FragmentNftDetailsBinding>(
    R.layout.fragment_nft_details
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
    }
    override fun initObserves() {
    }
    companion object {
        fun newInstance() = NftDetailFragment()
    }
}