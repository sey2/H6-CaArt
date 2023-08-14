package org.softeer_2nd.caArt.model.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.softeer_2nd.caArt.model.network.RetrofitClient
import org.softeer_2nd.caArt.model.network.TrimApiService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return RetrofitClient.getRetrofit()
    }

    @Provides
    fun provideTrimApiService(retrofit: Retrofit): TrimApiService {
        return retrofit.create(TrimApiService::class.java)
    }
}