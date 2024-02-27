package com.ewingelen.github.domain

interface Repository {

    suspend fun loadQuote(): Pair<Boolean, String>
}
