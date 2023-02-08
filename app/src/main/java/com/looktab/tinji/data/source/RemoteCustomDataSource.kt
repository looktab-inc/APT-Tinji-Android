package com.looktab.tinji.data.source

import com.looktab.tinji.data.api.AptosService
import com.looktab.tinji.data.api.CustomService
import com.looktab.tinji.data.model.Nft
import io.reactivex.rxjava3.core.Single

class RemoteCustomDataSource(
    private val service: CustomService
) :CustomDataSource {

    val address = "0x516f33eddd97b058868347d215392fd5bf20b223beadcd89ac62628ac7cad6c1"
    val collection = "Coll4"

    override fun getNfts(address:String,collection:String): Single<List<Nft>> {
        return service.getNfts(address=address, collection = collection).map{ m ->
//            val a = m.map {it ->
//                Nft(description= it.description, uri = it.uri, name = it.name)
//            }
            listOf<Nft>()
        }
    }
}