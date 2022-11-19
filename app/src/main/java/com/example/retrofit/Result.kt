package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class Result (
    @SerializedName("id")
    val id: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("sectionId")
    val sectionId: String,

    @SerializedName("sectionName")
    val sectionName: String,

    @SerializedName("webPublicationDate")
    val webPublicationDate: String,

    @SerializedName("webTitle")
    val webTitle: String,

    @SerializedName("webUrl")
    val webUrl: String,

    @SerializedName("apiUrl")
    val apiUrl: String,

    @SerializedName("isHosted")
    val isHosted: Boolean,

    @SerializedName("pillarId")
    val pillarId: String,

    @SerializedName("pillarName")
    val pillarName: String

)




