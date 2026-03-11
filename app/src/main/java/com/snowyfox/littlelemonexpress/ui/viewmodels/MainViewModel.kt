package com.snowyfox.littlelemonexpress.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snowyfox.littlelemonexpress.models.UserDataState
import com.snowyfox.littlelemonexpress.repository.IOnBoardingRepository
import com.snowyfox.littlelemonexpress.ui.events.UserEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: IOnBoardingRepository
) : ViewModel() {
    private val _mutableUiState = MutableStateFlow(UserDataState())
    val uiStateFlow: StateFlow<UserDataState> = _mutableUiState

    val state: StateFlow<UserDataState> = repository.getDataFromDatastore.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UserDataState()
    )

    fun onEvent(event: UserEvent) {
        when (event) {
            is UserEvent.SetFirstName -> viewModelScope.launch {
                _mutableUiState.update { userDataState -> userDataState.copy(firstName = event.firstname) }
            }

            is UserEvent.SetLastName -> viewModelScope.launch {
                _mutableUiState.update { userDataState -> userDataState.copy(lastName = event.lastName) }
            }

            is UserEvent.SetEmailAddress -> viewModelScope.launch {
                _mutableUiState.update { userDataState -> userDataState.copy(email = event.emailAddress) }
            }

            is UserEvent.IsUserLoggedIn -> viewModelScope.launch {
                _mutableUiState.update { userDataState -> userDataState.copy(isLoggedIn = event.loggedIn) }
            }

            is UserEvent.SaveUserData -> {
                val preferenceData = UserDataState(
                    firstName = uiStateFlow.value.firstName,
                    lastName = uiStateFlow.value.lastName,
                    email = uiStateFlow.value.email,
                    isLoggedIn = uiStateFlow.value.isLoggedIn
                )
                viewModelScope.launch {
                    repository.saveToDataStore(preferenceData)
                }
                _mutableUiState.update {
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

fun StateFlow<UserDataState>.toMutableFlow() =
    this.map { userDataState -> MutableStateFlow(userDataState) }
