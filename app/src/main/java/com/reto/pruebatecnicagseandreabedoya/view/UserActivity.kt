package com.reto.pruebatecnicagseandreabedoya.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reto.pruebatecnicagseandreabedoya.R
import com.reto.pruebatecnicagseandreabedoya.databinding.ActivityMainBinding
import com.reto.pruebatecnicagseandreabedoya.model.showUserModel
import com.reto.pruebatecnicagseandreabedoya.util.CardAdapter
import com.reto.pruebatecnicagseandreabedoya.viewModel.UserViewModel
import java.util.*
import kotlin.collections.ArrayList

class UserActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var resultAllUsers : MutableList<showUserModel>
    private lateinit var adapterUser: CardAdapter
    private lateinit var searchView : SearchView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_user)

        val rvUser : RecyclerView = findViewById(R.id.recyclerView)
        rvUser.layoutManager = LinearLayoutManager(this)

        searchView = findViewById(R.id.svSearch)

        //Call object observe
        val viewModelUser = ViewModelProvider(this).get(UserViewModel::class.java)
        val resultUserByName = viewModelUser.getUserByNombre("Ervin Howell")
        resultAllUsers = viewModelUser.getAllUsers()

        println(resultAllUsers)

        //Create de arrays
        val ids = arrayListOf<String>()
        val names = arrayListOf<String>()
        val userNames = arrayListOf<String>()
        val emails = arrayListOf<String>()
        val phones = arrayListOf<String>()
        val websites = arrayListOf<String>()

        for (i in resultAllUsers.indices) {
            ids.add(resultAllUsers[i].id.toString())
        }
        for (i in resultAllUsers.indices) {
            names.add(resultAllUsers[i].name.toString())
        }
        for (i in resultAllUsers.indices) {
            userNames.add(resultAllUsers[i].username.toString())
        }
        for (i in resultAllUsers.indices) {
            emails.add(resultAllUsers[i].email.toString())
        }
        for (i in resultAllUsers.indices) {
            phones.add(resultAllUsers[i].phone.toString())
        }
        for (i in resultAllUsers.indices) {
            websites.add(resultAllUsers[i].website.toString())
        }

        adapterUser = CardAdapter(resultAllUsers)
        rvUser.adapter = adapterUser



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.menu, menu)

        val searchItem = menu.findItem(R.id.actionSearch)

        searchView = findViewById(R.id.svSearch)

        searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {

                filter(newText)
                return false
            }
        })
        return true
    }

    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist : MutableList<showUserModel> = mutableListOf()

        // compare elements.
        for (item in resultAllUsers) {

            if (item.name.toLowerCase().contains(text.lowercase(Locale.getDefault()))) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {

            Toast.makeText(this, "No User Found..", Toast.LENGTH_SHORT).show()
        } else {

            adapterUser.setFilteredList(filteredlist)
        }
    }


}

