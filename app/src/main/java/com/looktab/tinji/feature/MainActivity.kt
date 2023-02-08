package com.looktab.tinji.feature

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.looktab.tinji.R
import com.looktab.tinji.base.BaseActivity
import com.looktab.tinji.data.injection.Injection
import com.looktab.tinji.databinding.ActivityMainBinding
import com.looktab.tinji.feature.airdrop.AirDropFragment
import com.looktab.tinji.feature.fragment.*
import com.looktab.tinji.feature.nft.NftDetailFragment
import com.looktab.tinji.feature.nft.NftFragment

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel by lazy {
        ViewModelProvider(
            viewModelStore, MainViewModelFactory(
                Injection.provideRemoteAptosSource(),
                Injection.provideRemoteCustomSource()
            )
        ).get(MainViewModel::class.java)
    }

    var my = MyPageFragment.newInstance()
    var airdrop = AirDropFragment.newInstance()
    var wallet = WalletFragment.newInstance()
    var nft = NftFragment.newInstance()

    override fun initViews() {
        super.initViews()
        binding.viewModel = viewModel
        changePage(airdrop)
        binding.btnNft.isActivated = true

        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this as FragmentActivity, arrayOf(Manifest.permission.CAMERA),
                MY_CAMERA_REQUEST_CODE
            )
//            requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);
        }

    }

    private val MY_CAMERA_REQUEST_CODE = 100

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_CAMERA_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun initObserves() {
        super.initObserves()
        viewModel.flow.observe(this, Observer {
            Log.e("flow", it.name)
            binding.btnAirdrop.isActivated = false
            binding.btnNft.isActivated = false
            binding.btnWallet.isActivated = false
            when (it) {
                MainViewModel.ViewFlow.Airdrop -> {
                    binding.btnAirdrop.isActivated = true
                    changePage(airdrop)
                }
                MainViewModel.ViewFlow.NFT -> {
                    binding.btnNft.isActivated = true
                    changePage(nft)
//                    nft.initViews()
                }
                MainViewModel.ViewFlow.Wallet -> {
                    binding.btnWallet.isActivated = true
                    changePage(wallet)
                }
                MainViewModel.ViewFlow.MyPage -> {
                    changePage(my)
                }
                MainViewModel.ViewFlow.Detail -> {
                    addOutFragment(NftDetailFragment.newInstance())
                }

                else -> {}
            }
        })
    }

    fun changePage(fragment: Fragment) {
        if (!fragment.isAdded) {
            addFragment(fragment)
            changeShowFragment(fragment)
        } else {
            changeHideFragment(my)
            changeHideFragment(airdrop)
            changeHideFragment(nft)
            changeHideFragment(wallet)
            changeShowFragment(fragment)
        }
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, fragment)
        }.commit()
    }

    private fun changeHideFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            hide(fragment)
        }.commit()
    }

    private fun changeShowFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            show(fragment)
        }.commit()
    }

    private fun addOutFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.out_fragment_container, fragment)
        }.commit()
    }

    override fun onBackPressed() {
        when (viewModel.flow.value) {
            MainViewModel.ViewFlow.Airdrop,
            MainViewModel.ViewFlow.NFT,
            MainViewModel.ViewFlow.MyPage,
            MainViewModel.ViewFlow.Wallet -> {
                super.onBackPressed()
            }

            MainViewModel.ViewFlow.ReviewWrite -> {
                viewModel.onClickReviewWriteFragmentEvent(viewModel.close)
            }
            MainViewModel.ViewFlow.QR -> {
                viewModel.onClickReviewWriteFragmentEvent(viewModel.close)
            }
            MainViewModel.ViewFlow.Detail -> {
                viewModel.onClickReviewWriteFragmentEvent(viewModel.close)
            }
            else -> {}
        }
    }

}