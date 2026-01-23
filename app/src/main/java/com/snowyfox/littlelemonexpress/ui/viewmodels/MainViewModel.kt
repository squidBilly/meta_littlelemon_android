package com.snowyfox.littlelemonexpress.ui.viewmodels

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snowyfox.littlelemonexpress.models.UserData
import com.snowyfox.littlelemonexpress.models.UserDataState
import com.snowyfox.littlelemonexpress.repository.AppPreferenceRepository
import com.snowyfox.littlelemonexpress.ui.events.UserEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: AppPreferenceRepository
) : ViewModel() {
    private val _userDataState = MutableStateFlow(value = UserDataState())
    val state: StateFlow<UserDataState> =
        combine(_userDataState, repository.getDataFromDatastore()) { state, userData ->
            state.copy(
                firstName = userData.firstName,
                lastName = userData.lastName,
                email = userData.email,
                isLoggedIn = userData.isLoggedIn
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(500L),
            initialValue = UserDataState()
        )
    val bState: StateFlow<UserDataState>  = repository.getDataFromDatastore().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(500),
        initialValue = UserDataState()
    )

    fun onEvent(event: UserEvent) {
        when (event) {
            is UserEvent.SetFirstName -> viewModelScope.launch {
                _userDataState.update { it.copy(firstName = event.firstname) }
            }

            is UserEvent.SetLastName -> viewModelScope.launch {
                _userDataState.update { it.copy(lastName = event.lastName) }
            }

            is UserEvent.SetEmailAddress -> viewModelScope.launch {
                _userDataState.update { it.copy(email = event.emailAddress) }
            }

            is UserEvent.IsUserLoggedIn -> viewModelScope.launch {
                _userDataState.update { it.copy(isLoggedIn = event.loggedIn) }
            }

            is UserEvent.RemoveProfile -> viewModelScope.launch {
                repository.clearDatastore()
            }

            is UserEvent.SaveUserData -> {
                val firstName = state.value.firstName
                val lastName = state.value.lastName
                val email = state.value.email
                val loggedIn = state.value.isLoggedIn
                if (firstName.isBlank() || lastName.isBlank() || email.isNotBlank()) {
                    return
                }
                val data = UserData(
                    firstName = firstName,
                    lastName = lastName,
                    email = email,
                    isLoggedIn = loggedIn
                )
                viewModelScope.launch {
                    repository.saveToDataStore(data)
                }
                _userDataState.update {
                    it.copy(
                        firstName = "",
                        lastName = "",
                        email = "",
                        isLoggedIn = false
                    )
                }
            }
        }
    }
}