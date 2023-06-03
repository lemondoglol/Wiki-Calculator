package com.example.wikicalculator.di

import android.content.Context
import android.content.SharedPreferences
import com.example.wikicalculator.core.ApplicationCoroutineScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    @Singleton
    internal fun provideApplicationCoroutineScope(): ApplicationCoroutineScope =
        ApplicationCoroutineScope(SupervisorJob())

    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("MY_DATA", Context.MODE_PRIVATE)
}
