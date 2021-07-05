package com.module.footballscores.dagger.component

import com.module.footballscores.utils.DetectConnection
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response


class ForceCacheInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        if (!DetectConnection.isInternetAvailable()) {
            builder.cacheControl(CacheControl.FORCE_CACHE)
        }
        return chain.proceed(builder.build())
    }

}
