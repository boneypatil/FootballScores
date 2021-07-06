package com.module.footballscores.dagger.module

import android.app.Application
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.module.footballscores.BuildConfig
import com.module.footballscores.dagger.component.ForceCacheInterceptor
import com.module.footballscores.network.MatchResultService
import com.module.footballscores.network.MatchResultSource

import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit

@Module
class NetworkModule(private val application: Application) {

    @Provides
    @Reusable
    internal fun provideOkHttpClient(): OkHttpClient {
        val cacheDir = File(application.cacheDir, UUID.randomUUID().toString())
        // 15 MiB cache
        val cache = Cache(cacheDir, 15 * 1024 * 1024)
        return OkHttpClient.Builder()
            .cache(
                cache
            )
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(ForceCacheInterceptor())
            .build()
    }

    @Provides
    @Reusable
    internal fun provideRetrofitInterface(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Reusable
    internal fun provideMatchResultService(retrofit: Retrofit): MatchResultService = retrofit.create(MatchResultService::class.java)

    @Provides
    @Reusable
    internal fun provideMatchResultSource(api: MatchResultService): MatchResultSource = MatchResultSource(api)

}