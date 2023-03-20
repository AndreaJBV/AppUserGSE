package com.reto.pruebatecnicagseandreabedoya.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.reto.pruebatecnicagseandreabedoya.JavaPerson
import com.reto.pruebatecnicagseandreabedoya.KotlinPerson
import com.reto.pruebatecnicagseandreabedoya.R


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myPersonKotlin: KotlinPerson = KotlinPerson("Andrea","Bedoya",160,65.0)
        var increaseWeight1 = myPersonKotlin.eat()
        var growUp1 = myPersonKotlin.growUp()

        println("La persona es: ${myPersonKotlin.name} ${myPersonKotlin.lastName} ")
        println("su altura inicial es: ${myPersonKotlin.height}")
        println("su peso inicial es: ${myPersonKotlin.weight}")
        println("la persona ha comido, por lo tanto su peso es: ${increaseWeight1}")
        println("la persona ha crecido, por lo tanto su altura es: ${growUp1}")

        println("--------------------------------------------------------------------------------------")

        var myPersonJava: JavaPerson = JavaPerson("Julieth","Valencia", 180,80.5)
        var increaseWeight2 = myPersonJava.eat()
        var growUp2 = myPersonJava.growUp()

        println("La persona es: ${myPersonJava.name} ${myPersonJava.lastName} ")
        println("su altura inicial es: ${myPersonJava.height}")
        println("su peso inicial es: ${myPersonJava.weight}")
        println("la persona ha comido, por lo tanto su peso es: ${increaseWeight2}")
        println("la persona ha crecido, por lo tanto su altura es: ${growUp2}")

        val imgLogo : ImageView = findViewById(R.id.logo)
        imgLogo.setOnClickListener{
            val oppenViewUser = Intent(this,UserActivity::class.java).apply {
                println("Se abrio la vista de usuarios")
            }
            startActivity(oppenViewUser)
        }



    }
}