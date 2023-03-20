package com.reto.pruebatecnicagseandreabedoya.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.databinding.adapters.CardViewBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.reto.pruebatecnicagseandreabedoya.R
import com.reto.pruebatecnicagseandreabedoya.databinding.ActivityCardviewBinding
import com.reto.pruebatecnicagseandreabedoya.model.showUserModel

class CardAdapter(var users: MutableList<showUserModel>): RecyclerView.Adapter<CardAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_cardview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]

        holder.tvid.text = user.id.toString()
        holder.tvname.text = user.name
        holder.tvuserName.text = user.username
        holder.tvemail.text = user.email
        holder.tvphone.text = user.phone
        holder.tvwebsite.text = user.website
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setFilteredList(users: MutableList<showUserModel>){
        this.users = users
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var tvid: TextView = itemView.findViewById(R.id.text_id)
        var tvname: TextView = itemView.findViewById(R.id.text_name)
        var tvuserName: TextView = itemView.findViewById(R.id.text_user_name)
        var tvemail: TextView = itemView.findViewById(R.id.text_email)
        var tvphone: TextView = itemView.findViewById(R.id.text_phone)
        var tvwebsite: TextView = itemView.findViewById(R.id.text_website)

    }

}