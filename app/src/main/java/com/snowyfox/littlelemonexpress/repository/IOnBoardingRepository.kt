package com.snowyfox.littlelemonexpress.repository


import com.snowyfox.littlelemonexpress.models.UserDataState
import kotlinx.coroutines.flow.Flow

interface IOnBoardingRepository {
    suspend fun saveToDataStore(userDataState: UserDataState)
    val getDataFromDatastore: Flow<UserDataState>
}