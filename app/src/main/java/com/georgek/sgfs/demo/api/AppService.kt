package com.georgek.sgfs.demo.api

import com.georgek.sgfs.demo.BuildConfig
import com.georgek.sgfs.demo.api.response.news.NewsResponse
import com.georgek.sgfs.demo.api.response.oauth.TokenResponse
import com.georgek.sgfs.demo.utils.Constants.Companion.GET_MOBILE_NEWS_URL
import com.georgek.sgfs.demo.utils.Constants.Companion.HTTP_HEADER_AUTHORIZATION
import com.georgek.sgfs.demo.utils.Constants.Companion.HTTP_HEADER_SCREEN
import retrofit2.Call
import retrofit2.http.*


interface AppService {

    @GET(BuildConfig.BASE_URL_ENDPOINT + GET_MOBILE_NEWS_URL)
    fun getNews(
            @Header(HTTP_HEADER_AUTHORIZATION) auth: String,
            @Header(HTTP_HEADER_SCREEN) screen: String
    ): Call<List<NewsResponse>>

    @FormUrlEncoded
    @POST(BuildConfig.TOKEN_URL)
    fun sendOauthRequest(
            @Header(HTTP_HEADER_AUTHORIZATION) auth: String,
            @Header(HTTP_HEADER_SCREEN) screen: String,

            @Field("username") username: String,
            @Field("password") password: String,
            @Field("grant_type") grant_type: String,
            @Field("scope") scope: String
    ): Call<TokenResponse>

}