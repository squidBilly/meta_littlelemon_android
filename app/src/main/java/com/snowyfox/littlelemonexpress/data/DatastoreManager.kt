package com.snowyfox.littlelemonexpress.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.snowyfox.littlelemonexpress.di.preferenceDatastore
import com.snowyfox.littlelemonexpress.models.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DatastoreManager(val context: Context) {
    companion object {
        val EMAIL = stringPreferencesKey("EMAIL")
        val FIRST_NAME = stringPreferencesKey("FIRST")
        val LAST_NAME = stringPreferencesKey("LAST")
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
    }

    suspend fun saveToDatastore(userData: UserData) {
        context.preferenceDatastore.edit { preferences ->
            preferences[EMAIL] = userData.email
            preferences[FIRST_NAME] = userData.firstName
            preferences[LAST_NAME] = userData.lastName
            preferences[IS_LOGGED_IN] = userData.isLoggedIn

        }
    }

    fun getDataFromDatastore(): Flow<UserData> = context.preferenceDatastore.data.map { userData ->
        UserData(
            email = userData[EMAIL] ?: "",
            firstName = userData[FIRST_NAME] ?: "",
            lastName = userData[LAST_NAME] ?: "",
            isLoggedIn = userData[IS_LOGGED_IN] ?: false
        )
    }

    suspend fun clearDatastore() = context.preferenceDatastore.edit { preferences ->
        preferences.clear()
    }
}