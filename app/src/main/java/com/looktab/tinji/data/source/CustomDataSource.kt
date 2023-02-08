package com.looktab.tinji.data.source

import com.looktab.tinji.data.model.Nft
import io.reactivex.rxjava3.core.Single

interface CustomDataSource {
    fun getNfts(address: String, collection: String): Single<List<Nft>>
}