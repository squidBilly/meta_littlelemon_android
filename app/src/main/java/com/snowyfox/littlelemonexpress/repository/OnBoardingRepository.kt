package com.snowyfox.littlelemonexpress.repository

import com.snowyfox.littlelemonexpress.data.IAppDatastore
import com.snowyfox.littlelemonexpress.models.UserDataState
import kotlinx.coroutines.flow.Flow

class OnBoardingRepository(private val dataStore: IAppDatastore): IOnBoardingRepository {
    override suspend fun saveToDataStore(userDataState: UserDataState) {
        dataStore.saveToDataStore(userDataState)
    }

    override val getDataFromDatastore: Flow<UserDataState>
        get() = dataStore.getDataFromDatastore
}