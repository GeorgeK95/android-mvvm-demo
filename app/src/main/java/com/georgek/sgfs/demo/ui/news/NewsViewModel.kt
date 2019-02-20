package com.georgek.sgfs.demo.ui.news

import android.arch.lifecycle.MutableLiveData
import com.georgek.sgfs.demo.api.response.news.NewsResponse
import com.georgek.sgfs.demo.repository.AppRepository
import com.georgek.sgfs.demo.ui.base.BaseViewModel
import javax.inject.Inject

class NewsViewModel @Inject constructor(
        private val appRepository: AppRepository
) : BaseViewModel() {

    val onNewsLoaded = MutableLiveData<List<NewsResponse>>()

    fun loadNews() {
        loading.postValue(true)
        executeSafeNetwork(
                networkTask = {
                    appRepository.loadNews()
                },
                success = {
                    onNewsLoaded.postValue(it)
                },
                error = {
                }
        )
    }

}