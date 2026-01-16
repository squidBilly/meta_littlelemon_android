package com.snowyfox.littlelemonexpress.ui.screens

import android.R.attr.label
import android.annotation.SuppressLint
import android.opengl.ETC1.isValid
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnBoardingScreen() {
    var email by remember { mutableStateOf(" ") }
    var firstName by remember { mutableStateOf(" ") }
    var lastName by remember { mutableStateOf(" ") }
    var isError by remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
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
        content = { paddingValues ->
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
                        .padding(32.dp),
                    verticalArrangement = Arrangement.spacedBy(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(64.dp))
                    OutlinedTextField(
                        modifier = Modifier.height(64.dp),
                        value = firstName,
                        onValueChange = { firstName = it },
                        label = { Text("First Name") },
                        placeholder = { Text("please enter a first name") }
                    )

                    OutlinedTextField(
                        modifier = Modifier.height(64.dp),
                        value = lastName,
                        onValueChange = { lastName = it },
                        label = { Text("Last Name") },
                        placeholder = { Text("please enter a your last name") }
                    )

                    OutlinedTextField(
                        modifier = Modifier.height(64.dp),
                        value = email,
                        onValueChange = {
                            email = it
                            isError = !isValid(it)
                        },
                        label = { Text("Email Address") },
                        placeholder = { Text("please enter a valid email address") },
                        isError = isError
                    )
                }
            }
        },
        containerColor = Color.White
    )
}

fun isValid(str: String): Boolean {
    return str.length in 6..<10
}