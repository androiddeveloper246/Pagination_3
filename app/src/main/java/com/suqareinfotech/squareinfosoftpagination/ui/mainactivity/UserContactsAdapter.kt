package com.suqareinfotech.squareinfosoftpagination.ui.mainactivity

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.suqareinfotech.squareinfosoftpagination.R
import com.suqareinfotech.squareinfosoftpagination.restufulservices.models.UsersModel
import com.suqareinfotech.squareinfosoftpagination.ui.infoactivity.InfoActivity
import com.suqareinfotech.squareinfosoftpagination.utils.ConstantKeys
import de.hdodenhof.circleimageview.CircleImageView

class UserContactsAdapter(var ctx: Context) : PagingDataAdapter<UsersModel, UserContactsAdapter.ContactsHolder>(
    DataDiffCallack()
) {

    class ContactsHolder(view : View) :RecyclerView.ViewHolder(view){

        var profilePic : CircleImageView = view.findViewById(R.id.profile_pic)
        var fName : TextView = view.findViewById(R.id.first_name)
        var lName : TextView = view.findViewById(R.id.last_name)
        var email : TextView = view.findViewById(R.id.email)
        var rootLayout : ConstraintLayout = view.findViewById(R.id.main_item_layout)

    }

    override fun onBindViewHolder(holder: ContactsHolder, position: Int) {

        var data : UsersModel = getItem(position)!!
        Glide.with(ctx).load(data.avatar).into(holder.profilePic)
        holder.fName.setText(data.first_name)
        holder.lName.setText(data.last_name)
        holder.email.setText(data.email)

        holder.rootLayout.setOnClickListener {

            var nextAct = Intent(ctx,InfoActivity::class.java)
            nextAct.putExtra(ConstantKeys.iProfilePic,data.avatar)
            nextAct.putExtra(ConstantKeys.iFirstName,data.first_name)
            nextAct.putExtra(ConstantKeys.iLastName,data.last_name)
            nextAct.putExtra(ConstantKeys.iEmail,data.email)
            ctx.startActivity(nextAct)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_contacts, parent, false)
        return ContactsHolder(inflater)
    }

    class DataDiffCallack : DiffUtil.ItemCallback<UsersModel>() {
        override fun areItemsTheSame(oldItem: UsersModel, newItem: UsersModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UsersModel, newItem: UsersModel): Boolean {
            return oldItem.first_name == newItem.first_name
                    && oldItem.last_name == newItem.last_name
        }

    }

}