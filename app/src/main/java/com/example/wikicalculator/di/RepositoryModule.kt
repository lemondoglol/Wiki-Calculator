package com.example.wikicalculator.di

import com.example.wikicalculator.data.UserPreferencesRepositoryImpl
import com.example.wikicalculator.data.datainterface.UserPreferencesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserPreferencesDataStoreRepository(
        userPreferencesRepositoryImpl: UserPreferencesRepositoryImpl,
    ): UserPreferencesRepository
}
