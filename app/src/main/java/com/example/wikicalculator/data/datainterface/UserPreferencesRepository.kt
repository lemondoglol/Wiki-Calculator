package com.example.wikicalculator.data.datainterface

import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {
    suspend fun setValue(key: String, value: String)
    suspend fun getValue(key: String): String?
    fun getValueAsFlow(key: String): Flow<String>
}
