package com.snowyfox.littlelemonexpress.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.snowyfox.littlelemonexpress.repository.AppPreferenceRepository
import com.snowyfox.littlelemonexpress.repository.IAppPreferencesRepository
import com.snowyfox.littlelemonexpress.ui.viewmodels.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("app_prefs")
val appModule = module {
    single { androidContext().dataStore }
    single { AppPreferenceRepository(get()) } bind IAppPreferencesRepository::class

}
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}