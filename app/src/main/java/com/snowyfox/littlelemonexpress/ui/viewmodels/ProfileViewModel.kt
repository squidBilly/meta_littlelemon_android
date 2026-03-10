package com.snowyfox.littlelemonexpress.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snowyfox.littlelemonexpress.models.UserDataState
import com.snowyfox.littlelemonexpress.repository.IProfileRepository
import com.snowyfox.littlelemonexpress.ui.events.ProfileUserEvents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: IProfileRepository) : ViewModel() {
    private val _useDataState = MutableStateFlow(UserDataState())
    val state: StateFlow<UserDataState> =
        combine(_useDataState, repository.getDataFromDatastore) { state, userData ->
            state.copy(
                firstName = userData.firstName,
                lastName = userData.lastName,
                email = userData.email,
                isLoggedIn = userData.isLoggedIn
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(500),
            initialValue = UserDataState()
        )

    fun onProfileEvent(profileEvents: ProfileUserEvents) {
        when (profileEvents) {
            is ProfileUserEvents.RemoveProfile -> viewModelScope.launch(Dispatchers.IO) {
                repository.clearDatastore()
            }

            is ProfileUserEvents.IsUserLoggedIn -> {
                _useDataState.update { it.copy(isLoggedIn = false) }
            }

            is ProfileUserEvents.SetEmailAddress -> {
                viewModelScope.launch {
                    _useDataState.update { userDataState -> userDataState.copy(email = profileEvents.email) }
                }

            }

            is ProfileUserEvents.SetLastName -> {
                viewModelScope.launch {
                    _useDataState.update { userDataState -> userDataState.copy(lastName = profileEvents.lastName) }
                }
            }

            is ProfileUserEvents.SetFirstName -> {
                _useDataState.update { userDataState -> userDataState.copy(firstName = profileEvents.firstName) }
            }
        }
    }
}