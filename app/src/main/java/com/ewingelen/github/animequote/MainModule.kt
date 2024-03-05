package com.ewingelen.github.animequote

import com.ewingelen.github.data.BaseRepository
import com.ewingelen.github.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface MainModule {

    @Binds
    @Singleton
    fun bindRepository(repository: BaseRepository): Repository
}
