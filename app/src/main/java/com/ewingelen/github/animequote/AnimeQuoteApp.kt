package com.ewingelen.github.animequote

import android.app.Application
import com.ewingelen.github.data.BaseRepository
import com.ewingelen.github.domain.Repository
import com.ewingelen.github.presentation.MainViewModel
import com.ewingelen.github.presentation.ProvideViewModel

class AnimeQuoteApp : Application(), ProvideViewModel {

    private lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        val repository: Repository = BaseRepository()
        viewModel = MainViewModel(repository)
    }

    override fun viewModel() = viewModel
}