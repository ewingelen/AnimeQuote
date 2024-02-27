package com.ewingelen.github.data

import com.ewingelen.github.domain.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseRepository(
    private val service: AnimeQuoteService
) : Repository {

    constructor() : this(
        Retrofit.Builder()
            .baseUrl("https://animechan.xyz")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeQuoteService::class.java)
    )

    override suspend fun loadQuote(): Pair<Boolean, String> {
        return try {
            val quote = service.animeQuote().quote
            Pair(true, quote)
        } catch (e: Exception) {
            Pair(false, e.message ?: "error")
        }
    }
}