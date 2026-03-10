package com.snowyfox.littlelemonexpress.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.snowyfox.littlelemonexpress.data.AppDatastore
import com.snowyfox.littlelemonexpress.data.IAppDatastore
import com.snowyfox.littlelemonexpress.repository.ILoginRepository
import com.snowyfox.littlelemonexpress.repository.IOnBoardingRepository
import com.snowyfox.littlelemonexpress.repository.LoginRepository
import com.snowyfox.littlelemonexpress.repository.OnBoardingRepository
import com.snowyfox.littlelemonexpress.ui.viewmodels.MainViewModel
import com.snowyfox.littlelemonexpress.ui.viewmodels.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("app_prefs")
val appModule = module {
    single { androidContext().dataStore}
    single { AppDatastore(get()) } bind IAppDatastore::class
    single { LoginRepository(get() ) } bind ILoginRepository::class
    single { OnBoardingRepository(get()) } bind IOnBoardingRepository:: class

}
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}