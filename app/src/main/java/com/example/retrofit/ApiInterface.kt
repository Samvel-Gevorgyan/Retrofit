package com.example.retrofit



import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("/search?api-key=086680c6-53f9-4216-a0b3-0097d1dc2376")
     fun getData() : Call<List<Result>>
}




