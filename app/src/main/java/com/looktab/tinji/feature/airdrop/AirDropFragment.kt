package com.looktab.tinji.feature.airdrop

import android.content.Context
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.fragment.app.activityViewModels
import com.looktab.tinji.R
import com.looktab.tinji.Util
import com.looktab.tinji.base.BaseFragment
import com.looktab.tinji.databinding.FragmentAirdropBinding
import com.looktab.tinji.feature.MainViewModel
import com.yuyakaido.android.cardstackview.*

class AirDropFragment : BaseFragment<FragmentAirdropBinding>(
    R.layout.fragment_airdrop
), CardStackListener {

    private val activityViewModel: MainViewModel by activityViewModels()
    lateinit var mContext: Context
    private val manager by lazy { CardStackLayoutManager(mContext, this) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun initViews() {
        binding.viewModel = activityViewModel
        initRecyclerView()
        binding.btnSave.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            binding.cardStackView.swipe()
        }
        binding.btnBurn.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            binding.cardStackView.swipe()
        }
    }


    private val swipeCardAdapter by lazy {
        SwipeCardAdapter().apply {
            setOnItemClickListener(object : SwipeCardAdapter.OnItemClickListener {
                override fun onItemClick(name: String) {
                }
            })
        }
    }

    private fun initRecyclerView() {
//        val cardStackView = findViewById<CardStackView>(R.id.card_stack_view)
        binding.cardStackView.layoutManager = CardStackLayoutManager(context)
        binding.cardStackView.adapter = swipeCardAdapter
        activityViewModel.initAirDrop()
    }

    override fun initObserves() {
        activityViewModel.airDrop.observe(this) {
            swipeCardAdapter.submitList(it)
        }
    }

    companion object {
        fun newInstance() = AirDropFragment()
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
        TODO("Not yet implemented")
    }

    override fun onCardSwiped(direction: Direction?) {
        when (direction) {
            Direction.Right -> {
                Util.createToast(mContext, "Right")
            }
            Direction.Left -> {
                Util.createToast(mContext, "Left")
            }
            else -> {
                Unit
            }
        }
        TODO("Not yet implemented")
    }

    override fun onCardRewound() {
        TODO("Not yet implemented")
    }

    override fun onCardCanceled() {
        TODO("Not yet implemented")
    }

    override fun onCardAppeared(view: View?, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        TODO("Not yet implemented")
    }
}


data class Spot(
    val id: Long = counter++,
    val name: String,
    val city: String,
    val url: String
) {
    companion object {
        private var counter = 0L
    }
}
