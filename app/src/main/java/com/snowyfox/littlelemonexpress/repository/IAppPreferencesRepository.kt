package com.snowyfox.littlelemonexpress.repository

import com.snowyfox.littlelemonexpress.models.UserData
import com.snowyfox.littlelemonexpress.models.UserDataState
import kotlinx.coroutines.flow.Flow

interface IAppPreferencesRepository {
    suspend fun saveToDataStore(userData: UserData)
    fun getDataFromDatastore(): Flow<UserDataState>
    suspend fun clearDatastore()
}