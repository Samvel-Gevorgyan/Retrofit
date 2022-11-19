package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var textId:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textId=findViewById(R.id.infoId)

     getMyData()
    }

    private fun getMyData(){
        val retrofitBuilder=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface:: class.java)


        val retrofitData=retrofitBuilder.getData()


        retrofitData.enqueue(object:Callback<List<Result>?> {
            override fun onResponse(call: Call<List<Result>?>, response: Response<List<Result>?>) {
                val responseBody = response.body()!!
                val myStringBuilder = StringBuilder()
                for (myData in responseBody) {
                    myStringBuilder.append(myData.id)
                    myStringBuilder.append("\n")
                }
                textId.text = myStringBuilder

            }

            override fun onFailure(call: Call<List<Result>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " + t.message)
            }

        })
}
    companion object{
        const val BASE_URL="https://content.guardianapis.com"
    }
}