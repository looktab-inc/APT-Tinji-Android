package com.looktab.tinji.data.model

import com.google.gson.annotations.SerializedName

data class NftResponse2(
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("maximum")
    val maximum: Int,
    @SerializedName("supply")
    val supply: Int,
    @SerializedName("uri")
    val uri: String,
//    @SerializedName("default_properties")
//    val default_properties: DefaultProperties,
//    @SerializedName("mutability_config")
//    val mutability_config: MutabilityConfig,
)
//
//data class MutabilityConfig(
//    @SerializedName("description")
//    val description: Boolean,
//    @SerializedName("maximum")
//    val maximum: Boolean,
//    @SerializedName("properties")
//    val properties: Boolean,
//    @SerializedName("royalty")
//    val royalty: Boolean,
//    @SerializedName("uri")
//    val uri: Boolean,
//)
//
//data class DefaultProperties(
//    @SerializedName("data")
//    val data: Data,
//)
//
//data class Data(
//    @SerializedName("key1")
//    val key1: Key1,
//    @SerializedName("key2")
//    val key2: Key2,
//)
//
//data class Key1(
//    @SerializedName("value")
//    val value: String,
//)
//
//data class Key2(
//    @SerializedName("value")
//    val value: String,
//)
//
