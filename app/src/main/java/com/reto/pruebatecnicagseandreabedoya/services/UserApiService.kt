package com.reto.pruebatecnicagseandreabedoya.services

import com.reto.pruebatecnicagseandreabedoya.model.UserDetailModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://jsonplaceholder.typicode.com"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface UserApiService {

    @GET("/users")
    suspend fun getUserByName(
        @Query("name") name: String
    ): MutableList<UserDetailModel>

    @GET("/users")
    suspend fun getAllUsers(): MutableList<UserDetailModel>

}

object UserApi {
    val retrofitService : UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }
}