package com.example.kot104_assignmentfinal.helper

import okhttp3.Interceptor
import okhttp3.Response

object RequestInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(request)
    }
}