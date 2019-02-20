package com.georgek.sgfs.demo.di.module

import com.georgek.sgfs.demo.ui.login.LoginActivity
import com.georgek.sgfs.demo.ui.news.NewsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    abstract fun bindNewsActivity(): NewsActivity
}