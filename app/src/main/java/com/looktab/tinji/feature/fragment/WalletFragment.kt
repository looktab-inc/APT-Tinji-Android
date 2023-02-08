package com.looktab.tinji.feature.fragment

import android.content.Context
import android.util.Log
import androidx.fragment.app.activityViewModels
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.looktab.tinji.R
import com.looktab.tinji.base.BaseFragment
import com.looktab.tinji.databinding.FragmentWalletBinding
import com.looktab.tinji.feature.MainViewModel
import com.looktab.tinji.feature.fragment.adapter.WalletCardAdapter
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.UnsupportedEncodingException


class WalletFragment : BaseFragment<FragmentWalletBinding>(
    R.layout.fragment_wallet
) {

    private val activityViewModel: MainViewModel by activityViewModels()
    lateinit var mContext: Context

    private val walletAdapter by lazy {
        WalletCardAdapter().apply {
            setOnItemClickListener(object : WalletCardAdapter.OnItemClickListener {
                override fun onItemClick(name: String) {
                }
            })
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context;
    }

    override fun initViews() {
        binding.viewModel = activityViewModel
        initRecyclerView()
        activityViewModel.getToken()
    }

    private fun initRecyclerView() {
        binding.rvWalletCard.apply {
            adapter = walletAdapter
            itemAnimator = null
        }
    }

    override fun initObserves() {
        activityViewModel.wallerToken.observe(this) {
            walletAdapter.submitList(it)
            activityViewModel.setTotalDollar()
        }
    }

    companion object {
        fun newInstance() = WalletFragment()
    }


}