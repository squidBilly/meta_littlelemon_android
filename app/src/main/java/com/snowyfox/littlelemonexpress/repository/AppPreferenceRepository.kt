package com.snowyfox.littlelemonexpress.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.snowyfox.littlelemonexpress.models.UserData
import com.snowyfox.littlelemonexpress.models.UserDataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppPreferenceRepository(val dataStore: DataStore<Preferences> ): IAppPreferencesRepository {
    companion object {
        val EMAIL = stringPreferencesKey("EMAIL")
        val FIRST_NAME = stringPreferencesKey("FIRST")
        val LAST_NAME = stringPreferencesKey("LAST")
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
    }
    override suspend fun saveToDataStore(userData: UserData) {
        dataStore.edit { preferences ->
            preferences[EMAIL] = userData.email
            preferences[FIRST_NAME] = userData.firstName
            preferences[LAST_NAME] = userData.lastName
            preferences[IS_LOGGED_IN] = userData.isLoggedIn
        }
    }

    override fun getDataFromDatastore(): Flow<UserDataState> {
       return dataStore.data.map { userData ->
          UserDataState(
                firstName = userData[FIRST_NAME] ?: "",
                lastName = userData[LAST_NAME] ?: "",
                email = userData[EMAIL] ?: "",
                isLoggedIn = userData[IS_LOGGED_IN] ?: false,
            )
        }
    }

    override suspend fun clearDatastore() {
       dataStore.edit { it.clear() }
    }
}