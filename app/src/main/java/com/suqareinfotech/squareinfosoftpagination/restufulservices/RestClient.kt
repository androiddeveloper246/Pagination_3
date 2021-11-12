package com.suqareinfotech.squareinfosoftpagination.restufulservices

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestClient {

    companion object {

        fun createClient(): ContactsServices {

            return Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ContactsServices::class.java)
        }
    }

}