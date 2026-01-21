package com.snowyfox.littlelemonexpress.di

import com.snowyfox.littlelemonexpress.ui.viewmodels.OnboardingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { OnboardingViewModel(get()) }
}