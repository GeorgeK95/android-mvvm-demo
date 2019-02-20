package com.georgek.sgfs.demo.ui.login

import android.arch.lifecycle.MutableLiveData
import com.georgek.sgfs.demo.api.response.oauth.TokenResponse
import com.georgek.sgfs.demo.repository.AppRepository
import com.georgek.sgfs.demo.ui.base.BaseViewModel
import javax.inject.Inject


data class LoginViewModel @Inject constructor(
        private val appRepository: AppRepository
) : BaseViewModel() {

    companion object {
    }

    val onTokenReceived = MutableLiveData<TokenResponse>()
    val onError = MutableLiveData<String>()

    fun oauthVM(us: String, pass: String, grandType: String) {
        loading.postValue(true)
        executeSafeNetwork(
                networkTask = {
                    appRepository.oauth(us, pass, grandType)
                },
                success = {
                    onTokenReceived.postValue(it)
                },
                error = {
                    onError.postValue(it.message)
                }
        )
    }

}