package com.reto.pruebatecnicagseandreabedoya.model

import com.google.gson.annotations.SerializedName

data class GeoModel (//The response whit retrofit is convert in this model
    @SerializedName("lat")     val lat: String,
    @SerializedName("lng")     val lng: String,

    )