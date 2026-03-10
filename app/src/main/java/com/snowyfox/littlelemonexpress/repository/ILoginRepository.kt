package com.snowyfox.littlelemonexpress.repository

import kotlinx.coroutines.flow.Flow

interface ILoginRepository {
    val getLoginState: Flow<Boolean>
}