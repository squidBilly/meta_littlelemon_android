package com.snowyfox.littlelemonexpress.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.snowyfox.littlelemonexpress.models.UserData
import kotlinx.coroutines.flow.map

const val USER_DATASTORE = "user_data"
val Context.preferenceDatastore: DataStore<Preferences> by preferencesDataStore(name = USER_DATASTORE)

class DatastoreManager(val context: Context) {
    companion object {
        val EMAIL = stringPreferencesKey("EMAIL")
        val FIRST_NAME = stringPreferencesKey("FIRST")
        val LAST_NAME = stringPreferencesKey("LAST")
    }

    suspend fun saveToDatastore(userData: UserData) {
        context.preferenceDatastore.edit { preferences ->
            preferences[EMAIL] = userData.email
            preferences[FIRST_NAME] = userData.firstName
            preferences[LAST_NAME] = userData.lastName
        }
    }

    fun getDataFromDatastore() = context.preferenceDatastore.data.map { userData ->
        UserData(
            email = userData[EMAIL] ?: "",
            firstName = userData[FIRST_NAME] ?: "",
            lastName = userData[LAST_NAME] ?: ""
        )
    }

    suspend fun clearDatastore() = context.preferenceDatastore.edit { preferences ->
        preferences.clear()
    }
}