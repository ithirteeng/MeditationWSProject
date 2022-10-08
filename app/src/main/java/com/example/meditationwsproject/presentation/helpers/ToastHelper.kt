package com.example.meditationwsproject.presentation.helpers

import android.content.Context
import android.widget.Toast

object ToastHelper {
    fun makeToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}