package com.looktab.tinji.data.source

import com.looktab.tinji.data.model.Nft
import io.reactivex.rxjava3.core.Single

interface AptosDataSource {
    fun getAccount(address: String): Single<Int>
    fun getNfts(address: String): Single<List<Nft>>
}