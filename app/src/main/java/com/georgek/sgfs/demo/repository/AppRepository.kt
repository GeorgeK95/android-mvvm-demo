package com.georgek.sgfs.demo.repository

import android.util.Base64
import com.georgek.sgfs.demo.api.AppService
import com.georgek.sgfs.demo.api.response.news.NewsResponse
import com.georgek.sgfs.demo.api.response.oauth.TokenResponse
import com.georgek.sgfs.demo.ui.login.LoginActivity
import com.georgek.sgfs.demo.utils.Constants.Companion.AUTH_TOKEN_BASIC_FORMAT
import com.georgek.sgfs.demo.utils.Constants.Companion.AUTH_TOKEN_BEARER_FORMAT
import com.georgek.sgfs.demo.utils.Constants.Companion.CLIENT_ID
import com.georgek.sgfs.demo.utils.Constants.Companion.CLIENT_SECRET
import com.georgek.sgfs.demo.utils.Constants.Companion.LOGIN_SCREEN_NAME
import com.georgek.sgfs.demo.utils.Constants.Companion.NEWS_SCREEN_NAME
import com.georgek.sgfs.demo.utils.Constants.Companion.NEW_LINE
import com.georgek.sgfs.demo.utils.Constants.Companion.SCOPE_READ
import com.georgek.sgfs.demo.utils.Constants.Companion.STRING_EMPTY
import retrofit2.Response
import javax.inject.Inject

class AppRepository @Inject constructor(private val appService: AppService) {

    fun loadNews(): Response<List<NewsResponse>> {
        val authHeader = String.format(AUTH_TOKEN_BEARER_FORMAT, LoginActivity.token!!.accessToken)
        return appService.getNews(authHeader, NEWS_SCREEN_NAME).execute()
    }

    fun oauth(username: String, password: String, grandType: String): Response<TokenResponse> {
        val auth = "$CLIENT_ID:$CLIENT_SECRET"
        val authHeader = String.format(AUTH_TOKEN_BASIC_FORMAT, String(android.util.Base64.encode(auth.toByteArray(), Base64.DEFAULT))
                .replace(NEW_LINE, STRING_EMPTY))
        return appService.sendOauthRequest(authHeader, LOGIN_SCREEN_NAME, username, password, grandType, SCOPE_READ).execute()
    }


}