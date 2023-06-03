package com.example.wikicalculator.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.wikicalculator.core.DispatcherProvider
import com.example.wikicalculator.data.datainterface.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserPreferencesRepositoryImpl @Inject constructor(
    private val userDataStore: DataStore<Preferences>,
    private val dispatcherProvider: DispatcherProvider,
) : UserPreferencesRepository {
    override suspend fun setValue(key: String, value: String): Unit = withContext(dispatcherProvider.io()) {
        val dataStoreKey = stringPreferencesKey(name = key)
        userDataStore.edit {
            it[dataStoreKey] = value
        }
    }

    override suspend fun getValue(key: String): String? = withContext(dispatcherProvider.io()) {
        val dataStoreKey = stringPreferencesKey(name = key)
        val preferences = userDataStore.data.first()
        return@withContext preferences[dataStoreKey]
    }

    override fun getValueAsFlow(key: String): Flow<String> {
        val dataStoreKey = stringPreferencesKey(name = key)
        return userDataStore.data.map {
            it[dataStoreKey]
        }.filterNotNull()
    }

    companion object {
        const val USER_NAME = "user_name"
    }
}