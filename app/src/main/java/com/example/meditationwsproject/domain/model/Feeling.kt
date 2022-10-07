package com.example.meditationwsproject.domain.model

import com.google.gson.annotations.SerializedName

data class Feeling(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("title")
    var title: String = "",
    @SerializedName("image")
    var imageSource: String = "",
    @SerializedName("position")
    var position: Int = 0
)