package com.looktab.tinji.data.api

import com.looktab.tinji.data.model.AccountResponse
import com.looktab.tinji.data.model.BaseData
import com.looktab.tinji.data.model.NftResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface AptosService {
    @GET("/v1/accounts/{Address}/resource/0x1::coin::CoinStore%3C0x1::aptos_coin::AptosCoin%3E")
    fun getAccount(
        @Path("Address") address: String
    ): Single<BaseData<AccountResponse>>

    ///accounts//transactions
    @GET("/v1/accounts/{Address}/transactions")
    fun getNfts(
        @Path("Address") address: String
    ): Single<List<NftResponse>>
}
