package com.looktab.tinji.data.injection

import com.looktab.tinji.data.api.ApiProvider
import com.looktab.tinji.data.source.RemoteAptosDataSource
import com.looktab.tinji.data.source.RemoteCustomDataSource

object Injection {
    fun provideRemoteAptosSource(): RemoteAptosDataSource {
        return RemoteAptosDataSource(ApiProvider.provideAptosApi())
    }

    fun provideRemoteCustomSource(): RemoteCustomDataSource {
        return RemoteCustomDataSource(ApiProvider.provideCustomsApi())
    }
}