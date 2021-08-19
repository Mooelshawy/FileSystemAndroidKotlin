package com.omran.accesssystemfile.api


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    //base url
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val client: OkHttpClient = OkHttpClient.Builder().build()

    private val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun<T> getApiCall(service : Class<T>):T{
        return  retrofit.create(service)
    }
}