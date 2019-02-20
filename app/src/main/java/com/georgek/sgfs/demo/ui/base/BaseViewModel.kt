package com.georgek.sgfs.demo.ui.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.georgek.sgfs.demo.api.response.BaseResponse
import com.georgek.sgfs.demo.api.response.error.ErrorResponse
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.Response

open class BaseViewModel : ViewModel() {

    companion object {
        const val ERROR_SERVER = "Server error!"
    }

    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    protected fun <T /*: BaseResponse*/> executeSafeNetwork(
            networkTask: () -> Response<T>,
            success: (result: T) -> Unit,
            error: (error: Exception) -> Unit
    ) {
        launch {
            try {
                val response = networkTask.invoke()

                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        success.invoke(body)
                    } else {
                        success.invoke(BaseResponse() as T)
                    }
                } else {
                    val gson = Gson()
                    val errorResponse =
                            gson.fromJson(response.errorBody()?.string(), ErrorResponse::class.java)

                    if (errorResponse.message == null) errorResponse.message = ERROR_SERVER
                    throw java.lang.Exception(errorResponse.message)
                }

            } catch (ex: Exception) {
                error.invoke(Exception(ex.message))
                this@BaseViewModel.error.postValue(ex.message)
            }
        }
    }


}