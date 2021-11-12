package com.suqareinfotech.squareinfosoftpagination.ui.mainactivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.suqareinfotech.squareinfosoftpagination.DataSource
import com.suqareinfotech.squareinfosoftpagination.restufulservices.ContactsServices
import com.suqareinfotech.squareinfosoftpagination.restufulservices.RestClient
import com.suqareinfotech.squareinfosoftpagination.restufulservices.models.UsersModel
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel : ViewModel(){

    var restfulServices : ContactsServices = RestClient.createClient()

    //
    fun getContactsData() : Flow<PagingData<UsersModel>> {
        return Pager (config = PagingConfig(pageSize = 3),
            pagingSourceFactory = { DataSource(restfulServices) }).flow.cachedIn(viewModelScope)
    }

}