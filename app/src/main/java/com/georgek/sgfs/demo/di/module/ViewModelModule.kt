package com.georgek.sgfs.demo.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.georgek.sgfs.demo.di.ViewModelFactory
import com.georgek.sgfs.demo.di.ViewModelKey
import com.georgek.sgfs.demo.ui.login.LoginViewModel
import com.georgek.sgfs.demo.ui.news.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun bindNewsActivityViewModel(viewModel: NewsViewModel): ViewModel

}