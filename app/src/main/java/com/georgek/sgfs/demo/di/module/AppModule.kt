package com.georgek.sgfs.demo.di.module

import android.content.Context
import com.georgek.sgfs.demo.DemoApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    internal fun provideContext(application: DemoApplication): Context {
        return application.applicationContext
    }

}