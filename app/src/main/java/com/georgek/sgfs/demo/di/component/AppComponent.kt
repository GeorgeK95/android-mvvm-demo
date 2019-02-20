package com.georgek.sgfs.demo.di.component

import com.georgek.sgfs.demo.DemoApplication
import com.georgek.sgfs.demo.di.module.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            (AppModule::class),
            (NetworkModule::class),
            (ActivityModule::class),
            (FragmentModule::class),
            (ViewModelModule::class),
            (AndroidSupportInjectionModule::class)]
)
interface AppComponent : AndroidInjector<DemoApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DemoApplication>()
}