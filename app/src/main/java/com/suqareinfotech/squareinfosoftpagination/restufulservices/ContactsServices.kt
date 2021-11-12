package com.suqareinfotech.squareinfosoftpagination.restufulservices

import com.suqareinfotech.squareinfosoftpagination.restufulservices.models.PageDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface ContactsServices {

    @GET("users")
    suspend fun getContacts(@Query("page")pageNum : Int, @Query("per_page")perPage : Int) : PageDetails
}