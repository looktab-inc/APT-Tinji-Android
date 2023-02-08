package com.looktab.tinji.data.api

import com.looktab.tinji.data.model.AccountResponse
import com.looktab.tinji.data.model.BaseData
import com.looktab.tinji.data.model.NftResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface CustomService {
    @GET("/nft-list/{Address}/{Collection}")
    fun getNfts(
        @Path("Address") address: String,
        @Path("Collection") collection: String,
    ): Single<List<NftResponse>>
}
