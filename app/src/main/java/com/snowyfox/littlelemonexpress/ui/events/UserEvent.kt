package com.snowyfox.littlelemonexpress.ui.events

sealed interface UserEvent {
    sealed class AddUserFirstname(firstname: String): UserEvent
    sealed class AddUserLastName(lastName: String): UserEvent
    sealed class AddUserEmail(emailAddress: String): UserEvent
}