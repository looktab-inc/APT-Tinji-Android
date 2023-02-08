package com.looktab.tinji.feature.nft

import android.content.Context
import android.util.Log
import androidx.fragment.app.activityViewModels
import com.looktab.tinji.R
import com.looktab.tinji.base.BaseFragment
import com.looktab.tinji.feature.MainViewModel

class NftFragment : BaseFragment<com.looktab.tinji.databinding.FragmentNftBinding>(
    R.layout.fragment_nft
) {

    private val activityViewModel: MainViewModel by activityViewModels()
    lateinit var mContext: Context
    private val nftCardAdapter by lazy {
        NFTCardAdapter().apply {
            setOnItemClickListener(object : NFTCardAdapter.OnItemClickListener {
                override fun onItemClick(id: Int) {
                    activityViewModel.selectNft(id)
                    activityViewModel.setViewFlow(MainViewModel.ViewFlow.Detail)
                }
            })
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context;
    }

    override fun initViews() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.nftsRecyclerView.adapter = nftCardAdapter
        activityViewModel.getNftCard()
    }
    override fun initObserves() {
        activityViewModel.nftList.observe(this) {
            Log.e("123",it.toString())
            nftCardAdapter.submitList(it)
        }
    }
    companion object {
        fun newInstance() = NftFragment()
    }
}