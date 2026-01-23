package com.snowyfox.littlelemonexpress.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snowyfox.littlelemonexpress.data.DatastoreManager
import com.snowyfox.littlelemonexpress.models.UserData
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val datastoreManager: DatastoreManager
) : ViewModel() {
    val userData: StateFlow<UserData> = datastoreManager.getDataFromDatastore()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UserData()
        )

    fun saveUserData(newUserData: UserData) {
        viewModelScope.launch {
            datastoreManager.saveToDatastore(newUserData)
            userData.value.copy(
                firstName = newUserData.firstName,
                lastName = newUserData.lastName,
                email = newUserData.email,
                isLoggedIn = newUserData.isLoggedIn
            )
        }
    }

    fun logInUser(loggedIn: Boolean) = viewModelScope.launch {
        datastoreManager.setLoggedInStatus(loggedIn)
        userData.value.copy(isLoggedIn = loggedIn)
    }

    fun removeProfile() = viewModelScope.launch {
        datastoreManager.clearDatastore()
        userData.value.copy(firstName = " ", lastName = " ", email = " ", isLoggedIn = false)
    }
}