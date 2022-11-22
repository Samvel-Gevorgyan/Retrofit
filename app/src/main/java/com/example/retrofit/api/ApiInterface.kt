package com.example.retrofit.api




import com.example.retrofit.data.model.guardia.GuardianNews
import com.example.retrofit.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("search")
    fun getData(@Query("api-key") apiKey:String = Constants.API_KEY) : Call<GuardianNews>
}




