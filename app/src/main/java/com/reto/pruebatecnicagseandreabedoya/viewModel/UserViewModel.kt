package com.reto.pruebatecnicagseandreabedoya.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import com.reto.pruebatecnicagseandreabedoya.model.UserDetailModel
import com.reto.pruebatecnicagseandreabedoya.model.showUserModel
import com.reto.pruebatecnicagseandreabedoya.services.UserApi
import kotlinx.coroutines.runBlocking

class UserViewModel: ViewModel() {
    private var name3: String = ""
    private var id : Int = 0
    private var user : String = ""
    private var email : String = ""
    private var phone : String = ""
    private var website : String = ""
    private val _status = MutableLiveData<String>()
    var name2: String= ""
    var message2: String = ""
    val gson = GsonBuilder().create()
    lateinit var result1 : List<UserDetailModel>
    lateinit var result2 : List<UserDetailModel>
    lateinit var resultUserByName : showUserModel
    var resultListUsers : MutableList<showUserModel> = mutableListOf()

    var size : Int = 0
    var size2 : Int = 0



    fun getUserByNombre(name: String) : showUserModel {
        runBlocking {
            try {

                result1 = UserApi.retrofitService.getUserByName(name)
                _status.value = "Success: ${result1} "
                println("Entro al try")
                size = result1.size
                if (size == 0) {
                    println("No se encontro ningun usuario")
                }else{

                    println("Usuario encontrado")
                    id = result1[0].id.toInt()
                    name3 = result1[0].name
                    user = result1[0].username
                    email = result1[0].email
                    phone = result1[0].phone
                    website = result1[0].website
                    resultUserByName = showUserModel(id,name3,user,email, phone, website)

                }

            } catch (e: Exception) {
                message2 = "No es correcto buscar usuario."
                println("Entro al catch")
                _status.value = "Failure: ${e.message}"
            }
            //println(resultUserShow)
            println("Mostrando el usuario desde el UserViewModel")
            return@runBlocking resultUserByName

        }
        return resultUserByName

    }
    fun getAllUsers() : MutableList<showUserModel> {
        runBlocking {
            try {

                result2 = UserApi.retrofitService.getAllUsers()
                _status.value = "Success: ${result2} "
                println("Entro al try")

                size2 = result2.size
                if (size2 == 0) {
                    println("No se encontro ningun usuario")
                }else{

                    println("Usuarios encontrados")
                    /*id = result1[0].id.toInt()
                    name3 = result1[0].name
                    user = result1[0].username
                    email = result1[0].email
                    phone = result1[0].phone
                    website = result1[0].website
                    resultUserByName = showUserModel(id,name3,user,email, phone, website)*/

                    for (i in result2.indices) {
                        //println(result2[i])
                        resultListUsers.add(showUserModel(result2[i].id,result2[i].name,result2[i].username,result2[i].email, result2[i].phone,result2[i].website))
                    }
                    println(resultListUsers[1])

                }


            } catch (e: Exception) {
                message2 = "No es correcto buscar todos los usuarios."
                println("Entro al catch")
                _status.value = "Failure: ${e.message}"
            }
            println(result2)
            println("Mostrando todos los usuario desde el UserViewModel")
            return@runBlocking resultListUsers

        }
        return resultListUsers

    }


}