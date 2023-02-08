package com.looktab.tinji.data.model

data class Nft(
    val description: String,
    val name: String,
    val uri: String,
    val property: Map<String,String>?
)
//
//data class Property(
//    val like: String,
//    val used: String,
//    val fee: String,
//    val startDate: String,
//    val endDate: String,
//    val zipCode: String,
//    val localAddress: String,
//    val localRange: String,
//)
