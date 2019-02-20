package com.georgek.sgfs.demo.api.response

import com.google.gson.annotations.SerializedName

open class BaseResponse(
        @SerializedName("error")
        var error: String? = ""
)