package com.reto.pruebatecnicagseandreabedoya

class KotlinPerson {
    //ATTRIBUTES
    var name: String = ""
    var lastName: String = ""
    var height: Int = 0
    var weight: Double = 0.0

    //CONSTRUCTOR
    constructor(name: String, lastName: String, height: Int, weight: Double) {
        this.name = name
        this.lastName = lastName
        this.height = height
        this.weight = weight
    }
    //METHODS
    fun eat(): Double{
        var increaseWeight = weight +1
        return increaseWeight
    }
    fun growUp(): Int{
        return ++height
    }

}