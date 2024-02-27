package com.ewingelen.github.data

import com.ewingelen.github.domain.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseRepository(private val service: AnimeQuoteService) : Repository {

    constructor() : this(
        Retrofit.Builder()
            .baseUrl("https://animechan.xyz")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeQuoteService::class.java)
    )

    override suspend fun loadQuote(): String {
        return try {
            service.animeQuote().quote
        } catch (e: Exception) {
            e.message ?: "error"
        }
    }
}
