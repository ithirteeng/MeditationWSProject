package com.example.meditationwsproject.presentation.helpers

import android.content.Context

object StringGetter {
    fun getString(context: Context, id: Int): String {
        return context.resources.getString(id)
    }
}