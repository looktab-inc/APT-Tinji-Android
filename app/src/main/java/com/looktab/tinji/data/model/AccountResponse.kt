package com.looktab.tinji.data.model

import com.google.gson.annotations.SerializedName

data class AccountResponse(
    @SerializedName("coin")
    val coin: Coin
)

data class Coin(
    @SerializedName("value")
    val value: String,
)
