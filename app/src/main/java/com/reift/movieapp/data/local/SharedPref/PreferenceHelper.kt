package com.reift.movieapp.data.local.SharedPref

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context, PrefName: String) {
    var sharedPref: SharedPreferences
    var prefEditor: SharedPreferences.Editor
    init {
        sharedPref = context.getSharedPreferences(PrefName, Context.MODE_PRIVATE)
        prefEditor = sharedPref.edit()
    }

    fun toArray(): List<String> {
        return sharedPref.toString().split(",")
    }



    override fun toString(): String {
        return sharedPref.toString().replace("{", "").replace("}", "").replace("\"", "")
    }

    fun put(key: String, value: String) {
        prefEditor.putString(key, value)
            .commit()
    }

    fun put(Key: String, value: Int) {
        prefEditor.putInt(Key, value)
            .commit()
    }

    fun put(Key: String, value: Boolean) {
        prefEditor.putBoolean(Key, value)
            .commit()
    }

    fun getString(key: String): String? {
        return sharedPref.getString(key, " ")
    }

    fun getBoolean(key: String): Boolean {
        return sharedPref.getBoolean(key, false)
    }

    fun getInt(key: String): Int {
        return sharedPref.getInt(key, 0)
    }

    fun remove(key: String){
        prefEditor.remove(key)
            .apply()
    }

    fun clear(){
        prefEditor.clear()
            .apply()
    }

}