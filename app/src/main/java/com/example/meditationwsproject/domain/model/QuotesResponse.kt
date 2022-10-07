package com.example.meditationwsproject.domain.model

import com.google.gson.annotations.SerializedName

data class QuotesResponse(
    @SerializedName("success")
    var success: Boolean = true,
    @SerializedName("data")
    var data: ArrayList<Quote> = arrayListOf()
)
