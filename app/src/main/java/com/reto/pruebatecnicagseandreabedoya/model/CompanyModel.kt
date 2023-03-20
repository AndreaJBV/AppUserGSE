package com.reto.pruebatecnicagseandreabedoya.model

import com.google.gson.annotations.SerializedName

data class CompanyModel (//The response whit retrofit is convert in this model
    @SerializedName("name")         val name: String,
    @SerializedName("catchPhrase")  val catchPhrase: String,
    @SerializedName("bs")           val bs : String,

    )