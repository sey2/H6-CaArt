package org.softeer_2nd.caArt.models.networks

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://api.ca-art.store/"
    private var retrofit: Retrofit? = null

    fun getRetrofit(): Retrofit = retrofit ?: Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


}