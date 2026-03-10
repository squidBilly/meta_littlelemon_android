package com.snowyfox.littlelemonexpress.data

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.snowyfox.littlelemonexpress.models.UserDataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class AppDatastore(val datastorePreferences: DataStore<Preferences>) : IAppDatastore {
    companion object Companion {
        val EMAIL = stringPreferencesKey("EMAIL")
        val FIRST_NAME = stringPreferencesKey("FIRST")
        val LAST_NAME = stringPreferencesKey("LAST")
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
    }

    override suspend fun saveToDataStore(userData: UserDataState) {
        datastorePreferences.edit { preferences ->
            preferences[FIRST_NAME] = userData.firstName
            preferences[LAST_NAME] = userData.lastName
            preferences[EMAIL] = userData.email
            preferences[IS_LOGGED_IN] = userData.isLoggedIn
        }
    }

    override val getDataFromDatastore: Flow<UserDataState> =
        datastorePreferences.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { userData ->
            UserDataState(
                firstName = userData[FIRST_NAME] ?: "",
                lastName = userData[LAST_NAME] ?: "",
                email = userData[EMAIL] ?: "",
                isLoggedIn = userData[IS_LOGGED_IN] ?: false,
            )
        }

    override suspend fun clearDatastore() {
        datastorePreferences.edit { it.clear() }
    }

    override val getLoginState: Flow<Boolean> =
        datastorePreferences.data.map { preferences ->
            preferences[IS_LOGGED_IN] ?: false
        }
}