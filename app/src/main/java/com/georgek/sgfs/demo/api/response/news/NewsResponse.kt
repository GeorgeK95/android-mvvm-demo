package com.georgek.sgfs.demo.api.response.news

import com.georgek.sgfs.demo.api.response.BaseResponse
import com.google.gson.annotations.SerializedName

data class NewsResponse(
        @SerializedName("newsId")
        var nid: Int
) : BaseResponse() {}