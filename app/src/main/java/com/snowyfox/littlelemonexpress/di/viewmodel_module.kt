package com.snowyfox.littlelemonexpress.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.snowyfox.littlelemonexpress.data.DatastoreManager
import com.snowyfox.littlelemonexpress.ui.viewmodels.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

const val USER_DATASTORE = "user_data"
val Context.preferenceDatastore: DataStore<Preferences> by preferencesDataStore(name = USER_DATASTORE)
val viewModelModule = module {
    single { get<Application>().preferenceDatastore }
    single { DatastoreManager(androidContext()) }
    viewModel { MainViewModel(get()) }
}