package com.looktab.tinji.feature.model

data class Pay(
    val name: String,
    val icon: String,
    val token: String,
    val isSelect: Boolean,
//    val nft: List<NFT>,
) {
    fun getPrice(): String {
        return token.toString()
    }
}