package com.georgek.sgfs.demo.utils

import android.content.Context
import android.preference.PreferenceManager

class SharedPrefsManager {
    companion object {
        fun addString(context: Context, key: String, value: String) {
            PreferenceManager
                    .getDefaultSharedPreferences(context)
                    .edit()
                    .putString(key, value)
                    .apply();
        }

        fun getString(context: Context, key: String, defValue: String): String {
            return PreferenceManager
                    .getDefaultSharedPreferences(context)
                    .getString(key, defValue)!!;
        }
    }
}