package com.snowyfox.littlelemonexpress.repository


import com.snowyfox.littlelemonexpress.data.IAppDatastore
import kotlinx.coroutines.flow.Flow

class LoginRepository(private val dataStore: IAppDatastore): ILoginRepository {
    override val getLoginState: Flow<Boolean>
        get() = dataStore.getLoginState
}