package com.snowyfox.littlelemonexpress.repository

import com.snowyfox.littlelemonexpress.models.UserDataState
import kotlinx.coroutines.flow.Flow


interface IProfileRepository {
    suspend fun saveToDataStore(userDataState: UserDataState)
    val getDataFromDatastore: Flow<UserDataState>
    suspend fun clearDatastore()
}