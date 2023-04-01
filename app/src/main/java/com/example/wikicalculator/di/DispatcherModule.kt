package com.example.wikicalculator.di

import com.example.wikicalculator.core.DefaultDispatcherProvider
import com.example.wikicalculator.core.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {

    /**
     * Coroutines
     * */
    @Binds
    @Singleton
    abstract fun bindDispatcherProvider(
        defaultDispatcherProvider: DefaultDispatcherProvider,
    ): DispatcherProvider
}