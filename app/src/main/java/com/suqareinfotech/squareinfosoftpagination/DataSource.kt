package com.suqareinfotech.squareinfosoftpagination

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.suqareinfotech.squareinfosoftpagination.restufulservices.ContactsServices
import com.suqareinfotech.squareinfosoftpagination.restufulservices.models.UsersModel

class DataSource(var restService: ContactsServices) : PagingSource<Int, UsersModel>() {

    private val TAG = "DataSource"

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UsersModel> {
        var initialPageIndex = params.key ?: 1
        val PER_PAGE = 10

        return try {

            val response = restService.getContacts(initialPageIndex,PER_PAGE)
            val res = response.data

            return LoadResult.Page(res, initialPageIndex-1,initialPageIndex+1)

        } catch (e: Exception) {
            Log.d(TAG, "load: ${e.message}")
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UsersModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}