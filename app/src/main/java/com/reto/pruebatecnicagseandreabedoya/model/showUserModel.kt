package com.reto.pruebatecnicagseandreabedoya.model

class showUserModel {
    var id: Number = 0
    var name: String = ""
    var username : String = ""
    var email : String = ""
    var phone : String = ""
    var website : String = ""

    constructor(id: Number,name: String, username: String, email: String, phone: String, website: String){
        this.id = id
        this.name = name
        this.username = username
        this.email = email
        this.phone = phone
        this.website = website
    }
}