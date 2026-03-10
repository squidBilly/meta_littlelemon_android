package com.snowyfox.littlelemonexpress.utility

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.snowyfox.littlelemonexpress.ui.events.UserEvent
import com.snowyfox.littlelemonexpress.ui.theme.EggShell
import com.snowyfox.littlelemonexpress.ui.viewmodels.MainViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun UtilityTestScreen(
    viewModel: MainViewModel = koinViewModel()
) {
    val uiState by viewModel.uiStateFlow.collectAsState()
    val state by viewModel.state.collectAsState()
    val events = viewModel::onEvent
    val context = LocalContext.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = EggShell)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = uiState.firstName,
                onValueChange = {
                    events(UserEvent.SetFirstName(it))
                },
                placeholder = { Text(text = "first name") }
            )
            TextField(
                value = uiState.lastName,
                onValueChange = {
                    events(UserEvent.SetLastName(it))
                },
                placeholder = { Text("last name") }
            )
            TextField(
                value = uiState.email,
                onValueChange = {
                    events(UserEvent.SetEmailAddress(it))
                },
                placeholder = { Text("email address") }
            )

            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                events(UserEvent.SaveUserData)
            }) { Text("Enter Data") }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                state.email.message(context)
            }) { Text("Email Button") }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                state.firstName.message(context)
            }) { Text("First Name") }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                state.lastName.message(context)
            }) { Text("Last Name") }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
            }) { Text("Clear Data") }
        }
    }
}