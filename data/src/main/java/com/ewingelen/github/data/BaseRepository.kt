package com.ewingelen.github.data

import com.ewingelen.github.domain.Repository
import javax.inject.Inject

class BaseRepository @Inject constructor(private val service: AnimeQuoteService) : Repository {

    override suspend fun loadQuote(): String {
        return try {
            service.animeQuote().quote
        } catch (e: Exception) {
            e.message ?: "error"
        }
    }
}
