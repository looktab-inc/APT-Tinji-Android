package com.looktab.tinji.data.model

import com.google.gson.annotations.SerializedName

data class NftResponse(
    @SerializedName("version")
    val version: String,
    @SerializedName("events")
    val events: List<Events>
)

data class Events(
    @SerializedName("data")
    val data: Data
)

data class Data(
    @SerializedName("name")
    val name: String?,
    @SerializedName("uri")
    val uri: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("property_keys")
    val property_keys: List<String>?,
    @SerializedName("property_types")
    val property_types: List<String>?,
    @SerializedName("property_values")
    val property_values: List<String>?,
)