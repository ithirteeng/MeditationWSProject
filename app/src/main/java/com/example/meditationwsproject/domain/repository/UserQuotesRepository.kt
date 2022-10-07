package com.example.meditationwsproject.domain.repository

import com.example.meditationwsproject.domain.model.Quote

interface UserQuotesRepository {
    fun getQuotes(): ArrayList<Quote>
}