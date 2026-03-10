package com.snowyfox.littlelemonexpress.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snowyfox.littlelemonexpress.repository.ILoginRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn


class LoginViewModel(repository: ILoginRepository) : ViewModel() {
    val logInState: StateFlow<Boolean> = repository.getLoginState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(500),
        initialValue = false
    )
}

