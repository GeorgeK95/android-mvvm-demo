package com.georgek.sgfs.demo.api.response.oauth

import com.georgek.sgfs.demo.api.response.BaseResponse
import com.google.gson.annotations.SerializedName

data class TokenResponse(
        @SerializedName("access_token")
        val accessToken: String,
        @SerializedName("result_code")
        val refreshToken: String,
        @SerializedName("expires_in")
        val expiresIn: Long,
        @SerializedName("token_type")
        val tokenType: String,
        @SerializedName("scope")
        val scope: String
) : BaseResponse() {
}