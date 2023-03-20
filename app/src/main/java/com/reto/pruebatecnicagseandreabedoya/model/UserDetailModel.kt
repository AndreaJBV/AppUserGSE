package com.reto.pruebatecnicagseandreabedoya.model

import com.google.gson.annotations.SerializedName

data class UserDetailModel (//The response whit retrofit is convert in this model
    @SerializedName("id")         val id: Number,
    @SerializedName("name")       val name: String,
    @SerializedName("username")   val username : String,
    @SerializedName("email")      val email : String,
    @SerializedName("address")    val address : Result<AddresModel>,
    @SerializedName("phone")      val phone : String,
    @SerializedName("website")    val website : String,
    @SerializedName("company")    val company : Result<CompanyModel>
    )