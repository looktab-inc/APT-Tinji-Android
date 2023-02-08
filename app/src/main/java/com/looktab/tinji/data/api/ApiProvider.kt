package com.looktab.tinji.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiProvider {
    const val APT_URL= "https://fullnode.devnet.aptoslabs.com"
    const val CUSTOM_URL= "https://port-0-node-express-1jx7m2gldmq9s9h.gksl2.cloudtype.app"

    fun provideAptosApi(): AptosService = getAPTRetrofitBuild.create(AptosService::class.java)
    fun provideCustomsApi(): CustomService = getCusomRetrofitBuild.create(CustomService::class.java)

    private var clientSignIn = OkHttpClient.Builder()
        .connectTimeout(1000, TimeUnit.SECONDS)
        .readTimeout(1000, TimeUnit.SECONDS)
        .writeTimeout(1000, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) })
        .addInterceptor { chain ->
            val newRequest = chain.request().newBuilder().apply {
            }.build()
            chain.proceed(newRequest)
        }.build()

    private val getAPTRetrofitBuild =
        Retrofit
            .Builder()
            .baseUrl(APT_URL)
            .client(clientSignIn)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val getCusomRetrofitBuild =
        Retrofit
            .Builder()
            .baseUrl(CUSTOM_URL)
            .client(clientSignIn)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}