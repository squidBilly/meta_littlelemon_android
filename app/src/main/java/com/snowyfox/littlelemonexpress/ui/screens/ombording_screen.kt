package com.snowyfox.littlelemonexpress.ui.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.sin

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnBoardingScreen() {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Green,
                    titleContentColor = Color.Green
                ),
                title = {
                    Box(
                        modifier = Modifier
                            .background(Color.Green),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "OnBoarding.",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        )
                    }
                },
            )
        },
        containerColor = Color.White
    ) { paddingValues ->
        var email by remember { mutableStateOf(" ") }
        var firstName by remember { mutableStateOf(" ") }
        var lastName by remember { mutableStateOf(" ") }
        var isError by remember { mutableStateOf(false) }
        val interactionSource = remember { MutableInteractionSource() }
        val isFocused by interactionSource.collectIsFocusedAsState()
        val focusRequester = remember { FocusRequester() }
        val focusManager = LocalFocusManager.current
        val scrollState = rememberScrollState()
        LaunchedEffect(isFocused) {
            if (isFocused){
                scrollState.animateScrollTo(scrollState.maxValue, tween(500))
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Spacer(modifier = Modifier.height(64.dp))
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(200.dp)
                    .padding(top = 64.dp),
                color = Color.Blue
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {

                    Text(
                        "Let's get to know you",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp,
                            color = Color.White
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .imePadding()
                    .verticalScroll(scrollState)
                    .padding(32.dp),
                verticalArrangement = Arrangement.spacedBy(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(64.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .height(64.dp)
                        .focusRequester(focusRequester),
                    value = firstName,
                    onValueChange = { firstName = it },
                    label = { Text("First Name") },
                    placeholder = { Text("please enter a first name") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    )
                )

                OutlinedTextField(
                    modifier = Modifier
                        .height(64.dp)
                        .focusRequester(focusRequester),
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = { Text("Last Name") },
                    placeholder = { Text("please enter a your last name") },
                    singleLine = true,
                )

                OutlinedTextField(
                    modifier = Modifier
                        .height(64.dp)
                        .focusRequester(focusRequester),
                    value = email,
                    onValueChange = {
                        email = it
                        isError = !isValid(it)
                    },
                    label = { Text("Email Address") },
                    placeholder = { Text("please enter a valid email address") },
                    isError = isError,
                    singleLine = true
                )
            }
        }
    }

}

fun isValid(str: String): Boolean {
    return str.length in 6..<10
}