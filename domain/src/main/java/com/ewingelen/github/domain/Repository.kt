package com.ewingelen.github.domain

interface Repository {

    suspend fun loadQuote(): String
}
