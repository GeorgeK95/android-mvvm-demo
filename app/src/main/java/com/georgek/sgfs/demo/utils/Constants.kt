package com.georgek.sgfs.demo.utils

class Constants {
    companion object {
        //auth
        const val CLIENT_ID = "android"
        const val CLIENT_SECRET = "android_secret"

        //http
        const val GRANT_TYPE_PASSWORD = "password"
        const val CHANEL = "Mobile-Android"
        const val SCOPE_READ = "read"

        //headers
        const val HTTP_HEADER_CHANEL = "EBank-Chanel"
        const val HTTP_HEADER_APPLICATION_VERSION = "EBank-App-Version"
        const val HTTP_HEADER_SCREEN = "EBank-Screen"
        const val HTTP_HEADER_DEVICE_ID = "EBank-Device-Id"
        const val HTTP_HEADER_ACCEPT_LANG = "Accept-Language"
        const val HTTP_HEADER_TIMESTAMP = "EBank-Client-Time"
        const val HTTP_HEADER_THEME = "EBank-Theme"
        const val HTTP_HEADER_CLIENT_VERSION = "EBank-Client-Version"
        const val HTTP_HEADER_ACCEPT = "Accept"
        const val HTTP_HEADER_CONTENT_TYPE = "Content-Type"
        const val HTTP_HEADER_AUTHORIZATION = "Authorization"

        //screens
        const val LOGIN_SCREEN_NAME = "LOGIN"
        const val NEWS_SCREEN_NAME = "MOB_NEWS"

        //patterns
        const val SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"
        const val AUTH_TOKEN_BASIC_FORMAT = "Basic %s"
        const val AUTH_TOKEN_BEARER_FORMAT = "Bearer %s"

        //urls
        const val GET_MOBILE_NEWS_URL = "sywsquery/sywsquery/getMobileNews"

        //other
        const val STRING_EMPTY = ""
        const val NEW_LINE = "\n"

        //SharedPrefsManager keys
        const val OAUTH_2_KEY = "oauth-2"

    }
}