package com.snowyfox.littlelemonexpress.data

import com.snowyfox.littlelemonexpress.models.UserDataState
import kotlinx.coroutines.flow.Flow

interface IAppDatastore {
    suspend fun saveToDataStore(userData: UserDataState)
    val getDataFromDatastore: Flow<UserDataState>
    suspend fun clearDatastore()
    val getLoginState: Flow<Boolean>
}