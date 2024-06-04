package com.example.kot104_assignmentfinal.helper

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://lobster-app-wos9a.ondigitalocean.app/"
    private val okHttpClient =
        OkHttpClient().newBuilder().addInterceptor(RequestInterceptor).build()

    fun getClient(): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create()).build()
}