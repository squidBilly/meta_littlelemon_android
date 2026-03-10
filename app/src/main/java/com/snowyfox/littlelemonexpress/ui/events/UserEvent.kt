package com.snowyfox.littlelemonexpress.ui.events

sealed interface UserEvent {
    data class SetFirstName(val firstname: String): UserEvent
    data class SetLastName(val lastName: String): UserEvent
    data class SetEmailAddress(val emailAddress: String): UserEvent
    data class IsUserLoggedIn( val loggedIn: Boolean): UserEvent
    data object SaveUserData: UserEvent
}
sealed interface ProfileUserEvents {
    data object RemoveProfile: ProfileUserEvents
    data class IsUserLoggedIn(val loggedIn: Boolean): ProfileUserEvents
    data class SetEmailAddress(val email: String): ProfileUserEvents
    data class SetFirstName(val firstName: String): ProfileUserEvents
    data class SetLastName(val lastName: String): ProfileUserEvents
}