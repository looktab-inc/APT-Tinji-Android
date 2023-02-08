package com.looktab.tinji.data.source

import com.looktab.tinji.data.api.AptosService
import com.looktab.tinji.data.model.Nft
import io.reactivex.rxjava3.core.Single
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okio.Utf8

class RemoteAptosDataSource(
    private val service: AptosService,
) : AptosDataSource {

    override fun getAccount(address: String): Single<Int> {
        return service.getAccount(address).map { it ->
            if (it.data == null)
                0
            else
                it.data.coin.value.toInt()
        }
    }

    override fun getNfts(address: String): Single<List<Nft>> {
        return service.getNfts(address = address).map { _res ->
            val res = _res.map { d1 ->
                d1.events.firstOrNull{
                     it.data.name!= null
                 }
            }

            res.filterNotNull().map { event ->
                event.data.let {
                    Nft(
                        name = it.name ?: "",
                        uri = it.uri ?: "",
                        description = it.description ?: "",
                        property =
                        if (it.property_keys == null
                            || it.property_values == null
                        ) null
                        else property(
                            it.property_keys,
                            it.property_values
                        )
                    )
                }
            }
        }
    }


//    @Serializable
//    data class Data(val a: String, val b: String)

    fun property(key: List<String>, value: List<String>): MutableMap<String, String> {
        val map = mutableMapOf<String, String>()
        key.forEachIndexed { index, key ->
//            val text = String(value[index], Utf8)
//            map[key] = Json.decodeFromString<String>("${value[index]}")
            map[key] = value[index]
        }

        return map
    }
}