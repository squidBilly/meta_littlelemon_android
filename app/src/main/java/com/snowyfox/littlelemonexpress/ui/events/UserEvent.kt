package com.snowyfox.littlelemonexpress.ui.events

sealed interface UserEvent {
    data class SetFirstName(val firstname: String): UserEvent
    data class SetLastName(val lastName: String): UserEvent
    data class SetEmailAddress(val emailAddress: String): UserEvent
    data class IsUserLoggedIn( val loggedIn: Boolean): UserEvent
    data object RemoveProfile : UserEvent
    data object SaveUserData: UserEvent
}