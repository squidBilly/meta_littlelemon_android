package com.snowyfox.littlelemonexpress.repository

import com.snowyfox.littlelemonexpress.data.IAppDatastore
import com.snowyfox.littlelemonexpress.models.UserDataState
import kotlinx.coroutines.flow.Flow

class ProfileRepository(private val datastore: IAppDatastore) : IProfileRepository {
    override suspend fun saveToDataStore(userDataState: UserDataState) {
        datastore.saveToDataStore(userDataState)
    }

    override val getDataFromDatastore: Flow<UserDataState>
        get() = datastore.getDataFromDatastore

    override suspend fun clearDatastore() {
        datastore.clearDatastore()
    }
}

