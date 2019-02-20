package com.georgek.sgfs.demo.api.response.error

import com.google.gson.annotations.SerializedName

class ErrorResponse {
    @SerializedName("message")
    var message: String? = ""
    @SerializedName("status")
    var status: String? = ""
    @SerializedName("httpStatusCode")
    var httpStatusCode: String? = ""
    @SerializedName("userAuthRule")
    var userAuthRule: String = ""
    @SerializedName("refNo")
    var refNo: String? = ""
    @SerializedName("messageCode")
    var messageCode: String? = ""
    @SerializedName("externalRef")
    var externalRef: String? = ""
    @SerializedName("statusDesc")
    var statusDesc: String? = ""
}
