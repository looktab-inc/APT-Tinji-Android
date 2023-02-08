package com.looktab.tinji.feature

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.looktab.tinji.base.BaseViewModel
import com.looktab.tinji.base.Event
import com.looktab.tinji.data.source.AptosDataSource
import com.looktab.tinji.data.source.CustomDataSource
import com.looktab.tinji.feature.model.Nft
import com.looktab.tinji.feature.model.Token
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.math.roundToInt

class MainViewModel(
    private val aptosDataSource: AptosDataSource,
    private val customDataSource: CustomDataSource
) : BaseViewModel() {
    val close = "close"

    private val _reviewWriteEvent = MutableLiveData<Event<String>>()
    val reviewWriteEvent: LiveData<Event<String>> get() = _reviewWriteEvent

    fun onClickReviewWriteFragmentEvent(text: String) {
        _reviewWriteEvent.value = Event(text)
    }

    val address = "0xf12c242d1aa43c74fa8c8a5e80be3c73f52a7a40d199d2a2b968d54bdb9d2622"

    private val _wallerToken = MutableLiveData<List<Token>>()
    val wallerToken: LiveData<List<Token>> get() = _wallerToken

    private val _totalDollar = MutableLiveData<String>()
    val totalDollar: LiveData<String> = _totalDollar

    enum class ViewFlow { Airdrop, NFT, Wallet, MyPage, QR, Login, Detail, ReviewWrite }

    private val _flow = MutableLiveData<ViewFlow>()
    val flow: LiveData<ViewFlow> = _flow

    fun setViewFlow(state: ViewFlow) {
        _flow.value = state
    }

    private val _airDrop = MutableLiveData<List<Nft>>()
    val airDrop: LiveData<List<Nft>> get() = _airDrop

    fun initAirDrop() {
        _airDrop.value = listOf<Nft>(
            Nft(
                id = 1,
                image = "https://raw.githubusercontent.com/Looktab-naer/imgs/main/apt1.png",
                title = "Overflow",
                content = "Overflow",
            ),
            Nft(
                id = 2,
                image = "https://raw.githubusercontent.com/Looktab-naer/imgs/main/apt2.png",
                title = "Overflow",
                content = "Overflow",
            ),
            Nft(
                id = 3,
                image = "https://raw.githubusercontent.com/Looktab-naer/imgs/main/apt3.png",
                title = "Overflow",
                content = "Overflow",
            ),
            Nft(
                id = 3,
                image = "https://raw.githubusercontent.com/Looktab-naer/imgs/main/apt4.png",
                title = "Overflow",
                content = "Overflow",
            ),
        )
    }

    private val _nftList = MutableLiveData<List<Nft>>()
    val nftList: LiveData<List<Nft>> get() = _nftList

    val detailNFT = MutableLiveData<Nft>()
    fun selectNft(id: Int) {
        detailNFT.value = nftList.value?.first {
            it.id == id
        }
    }

    fun getNftCard() {
        aptosDataSource.getNfts(address)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ res ->
                _nftList.postValue(
                    res.map {
                        Nft(
                            id = 0,
                            image = it.uri,
                            title = it.name,
                            content = it.description,
                        )
                    })

                Log.e("getNfts ", res.toString())
            }, { e ->
                Log.e("getNfts ERROR", e.toString())
            })
    }

    val apt = MutableLiveData<String>()

    fun getToken() {
        aptosDataSource.getAccount(address)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                apt.postValue( "${(it.toInt()/1000000)*100.0.roundToInt() / 100.0}")
                Log.e("getAccount ", it.toString())
            }, { e ->
                Log.e("getAccount ERROR", e.toString())
            })

        _wallerToken.value = listOf<Token>(
            Token(
                name = "Reward",
                icon = "https://raw.githubusercontent.com/Looktab-naer/imgs/main/apt4.png",
                token = 2.23142, tokenWord = "To : HX94...2394", dollar = 23.0, dollarGap = +0.100
            ),
            Token(
                name = "Reward",
                icon = "https://raw.githubusercontent.com/Looktab-naer/imgs/main/apt3.png",
                token = 2.23142, tokenWord = "To : HX94...2394", dollar = 23.0, dollarGap = +0.100
            ),
            Token(
                name = "Reward",
                icon = "https://raw.githubusercontent.com/Looktab-naer/imgs/main/apt2.png",
                token = 2.23142, tokenWord = "To : HX94...2394", dollar = 23.0, dollarGap = +0.100
            ),
            Token(
                name = "Reward",
                icon = "https://raw.githubusercontent.com/Looktab-naer/imgs/main/apt1.png",
                token = 2.23142, tokenWord = "To : HX94...2394", dollar = 23.0, dollarGap = +0.100
            ),
            Token(
                name = "Reward",
                icon = "https://raw.githubusercontent.com/Looktab-naer/imgs/main/apt5.png",
                token = 2.23142, tokenWord = "To : HX94...2394", dollar = 23.0, dollarGap = +0.100
            ),
        )
    }

    fun setTotalDollar() {
        var sum = 0.0
        wallerToken.value?.forEach {
            sum += it.getHoldingDollar()
        }
        _totalDollar.value = ((sum * 100.0).roundToInt() / 100.0).toString()
    }

    private val _reviewHistory = MutableLiveData<Boolean>(false)
    val reviewHistory: LiveData<Boolean> = _reviewHistory

    fun setReviewHistory(boolean: Boolean) {
        _reviewHistory.value = boolean
    }
}