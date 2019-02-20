package com.georgek.sgfs.demo.di.module

import com.georgek.sgfs.demo.BuildConfig
import com.georgek.sgfs.demo.api.AppService
import com.georgek.sgfs.demo.api.interceptor.BaseInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder().setDateFormat("yyyy-MM-dd").create()
    }

    @Provides
    @Singleton
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(
            baseInterpolator: BaseInterceptor, loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val result = OkHttpClient.Builder()
        result.hostnameVerifier { hostname, session -> true }

        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            result.addInterceptor(loggingInterceptor)
        }

        result.addInterceptor(baseInterpolator)

        return result.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.BASE_URL_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Provides
    @Singleton
    internal fun provideAppService(retrofit: Retrofit): AppService {
        return retrofit.create(AppService::class.java)
    }

}