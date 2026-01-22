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

    fun saveUserData(userData: UserData) {
        viewModelScope.launch {
            datastoreManager.saveToDatastore(userData)
        }
    }

    fun logInUser() = viewModelScope.launch {
        datastoreManager.setLoggedInStatus(true)
    }

    fun removeProfile() = viewModelScope.launch {
        datastoreManager.clearDatastore()
    }
}