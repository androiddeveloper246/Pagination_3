package com.suqareinfotech.squareinfosoftpagination.ui.infoactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.suqareinfotech.squareinfosoftpagination.R
import com.suqareinfotech.squareinfosoftpagination.databinding.ActivityInfoBinding
import com.suqareinfotech.squareinfosoftpagination.utils.ConstantKeys

class InfoActivity : AppCompatActivity() {

    lateinit var binding : ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Glide.with(this).load(intent.getStringExtra(ConstantKeys.iProfilePic)).into(binding.infoProfilePic)
        binding.infoFName.setText(intent.getStringExtra(ConstantKeys.iFirstName))
        binding.infoLName.setText(intent.getStringExtra(ConstantKeys.iLastName))
        binding.infoEmail.setText(intent.getStringExtra(ConstantKeys.iEmail))

    }
}