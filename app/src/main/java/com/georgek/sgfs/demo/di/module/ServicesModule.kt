package com.georgek.sgfs.demo.di.module

import com.georgek.sgfs.demo.api.AppService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServicesModule {

    @Provides
    @Singleton
    internal fun provideAppService(retrofit: Retrofit) =
            retrofit.create(AppService::class.java)

}