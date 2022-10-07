package com.example.meditationwsproject.domain.model

import com.google.gson.annotations.SerializedName

data class FeelingsResponse(
    @SerializedName("success")
    var success: Boolean = true,
    @SerializedName("data")
    var data: ArrayList<Feeling> = arrayListOf()
)
