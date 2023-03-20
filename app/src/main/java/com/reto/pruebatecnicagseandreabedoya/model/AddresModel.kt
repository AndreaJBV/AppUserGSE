package com.reto.pruebatecnicagseandreabedoya.model

import com.google.gson.annotations.SerializedName

data class AddresModel (//The response whit retrofit is convert in this model
    @SerializedName("street")    val street: String,
    @SerializedName("suite")     val suite: String,
    @SerializedName("city")      val city : String,
    @SerializedName("zipcode")   val zipcode : String,
    @SerializedName("geo")       val geo : Result<GeoModel>,
    )