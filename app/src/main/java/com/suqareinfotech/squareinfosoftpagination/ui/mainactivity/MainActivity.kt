package com.suqareinfotech.squareinfosoftpagination.ui.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.suqareinfotech.squareinfosoftpagination.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {

    lateinit var actBinding : ActivityMainBinding
    lateinit var userDataAdapter: UserContactsAdapter
    lateinit var mainActViewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(actBinding.root)

        mainActViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        // initialize recycler view
        actBinding.contactsRecView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            userDataAdapter = UserContactsAdapter(this@MainActivity)
            adapter = userDataAdapter
        }

        // fill adapter with data
        lifecycleScope.launchWhenCreated {
            mainActViewModel.getContactsData().collectLatest {
                userDataAdapter.submitData(it)
            }
        }
    }
}