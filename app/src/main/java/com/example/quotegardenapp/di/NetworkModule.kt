package com.example.quotegardenapp.di

import com.example.quotegardenapp.data.remote.ApiDetails
import com.example.quotegardenapp.data.remote.ApiReferences
import com.example.quotegardenapp.data.repository.Repository
import com.example.quotegardenapp.data.repository.RepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

//    @Provides
//    fun provideLoggingIntercepter(): HttpLoggingInterceptor{
//        return HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//    }

    @Provides
    fun provideClient(
//        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient{
       val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor( loggingInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit{
        return Retrofit.Builder()
            .baseUrl(ApiReferences.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }

    @Provides
    fun provideApiDetails(
        retrofit: Retrofit
    ):ApiDetails{
        return retrofit.create(ApiDetails::class.java)
    }

    @Provides
    fun provideRepository(
        apiDetails: ApiDetails
    ): Repository{
        return RepositoryImpl(apiDetails)
    }
}