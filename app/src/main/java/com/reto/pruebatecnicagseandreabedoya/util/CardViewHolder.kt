package com.reto.pruebatecnicagseandreabedoya.util

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.reto.pruebatecnicagseandreabedoya.databinding.ActivityCardviewBinding
import com.reto.pruebatecnicagseandreabedoya.model.showUserModel

class CardViewHolder (private val cardviewBinding: ActivityCardviewBinding) : RecyclerView.ViewHolder(cardviewBinding.root) {

    fun bindUser(user: showUserModel){
        cardviewBinding.textId.text = user.id.toString()
        cardviewBinding.textName.text = user.name
        cardviewBinding.textUserName.text = user.username
        cardviewBinding.textEmail.text = user.email
        cardviewBinding.textPhone.text = user.phone
        cardviewBinding.textWebsite.text = user.website



    }

}