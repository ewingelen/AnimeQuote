package com.ewingelen.github.data

import retrofit2.http.GET

interface AnimeQuoteService {

    @GET("/api/random")
    suspend fun animeQuote(): AnimeQuoteCloud
}
