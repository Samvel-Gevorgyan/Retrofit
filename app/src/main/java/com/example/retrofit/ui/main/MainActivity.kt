package com.example.retrofit.ui.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit.api.ApiClient
import com.example.retrofit.data.model.guardia.GuardianNews
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


//    private val api: ApiInterface by lazy {
//        ApiClient().getClient().create(ApiInterface::class.java)
//    }

    private val newsAdapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newsRecyclerView.adapter = newsAdapter

        ApiClient.getGuardianApiService().getData().enqueue(object : Callback<GuardianNews> {
            @SuppressLint("LongLogTag")
            override fun onResponse(call: Call<GuardianNews>, response: Response<GuardianNews>) {
                Log.d("GuardianNews-onResponse:", "response:${response.body().toString()}")
                newsAdapter.updateData(response.body()?.response?.results)
            }

            override fun onFailure(call: Call<GuardianNews>, t: Throwable) {
                Log.d(
                    "GuardianNews-onFailure:",
                    "Throwable:${t.message.toString()} or errorResponse:${call.request().body} and request url ${call.request().url}"
                )
            }
        })
    }
}



