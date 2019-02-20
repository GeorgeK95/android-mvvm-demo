package com.georgek.sgfs.demo.api.interceptor

import android.content.Context
import android.os.Build
import com.georgek.sgfs.demo.utils.Constants.Companion.CHANEL
import com.georgek.sgfs.demo.utils.Constants.Companion.HTTP_HEADER_ACCEPT
import com.georgek.sgfs.demo.utils.Constants.Companion.HTTP_HEADER_ACCEPT_LANG
import com.georgek.sgfs.demo.utils.Constants.Companion.HTTP_HEADER_APPLICATION_VERSION
import com.georgek.sgfs.demo.utils.Constants.Companion.HTTP_HEADER_CHANEL
import com.georgek.sgfs.demo.utils.Constants.Companion.HTTP_HEADER_CLIENT_VERSION
import com.georgek.sgfs.demo.utils.Constants.Companion.HTTP_HEADER_CONTENT_TYPE
import com.georgek.sgfs.demo.utils.Constants.Companion.HTTP_HEADER_DEVICE_ID
import com.georgek.sgfs.demo.utils.Constants.Companion.HTTP_HEADER_THEME
import com.georgek.sgfs.demo.utils.Constants.Companion.HTTP_HEADER_TIMESTAMP
import com.georgek.sgfs.demo.utils.Constants.Companion.SERVER_DATE_FORMAT
import okhttp3.Interceptor
import okhttp3.Response
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class BaseInterceptor @Inject constructor(val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        //todo: unhardcode values
        val finalRequest = request.newBuilder()
                .addHeader(HTTP_HEADER_CHANEL, CHANEL)
                .addHeader(HTTP_HEADER_APPLICATION_VERSION, "194") //Utils.getApplicationVersionCode(context)
                .addHeader(HTTP_HEADER_DEVICE_ID, "fd09b975-2a3b-4dae-add5-c458bddc993f") //DeviceParameters.getGUIDInstalation() Utils.id(context)
                .addHeader(HTTP_HEADER_ACCEPT_LANG, "bg")
                .addHeader(HTTP_HEADER_TIMESTAMP, SimpleDateFormat(SERVER_DATE_FORMAT, Locale.US).format(Calendar.getInstance().time))
                .addHeader(HTTP_HEADER_CLIENT_VERSION, Build.VERSION.RELEASE)
                .addHeader(HTTP_HEADER_ACCEPT, "application/json") //application/x-www-form-urlencoded
                .addHeader(HTTP_HEADER_CONTENT_TYPE, "application/json") //x-www-form-urlencoded
                .addHeader(HTTP_HEADER_THEME, "E_MOBILE")

        return chain.proceed(finalRequest.build())
    }

}