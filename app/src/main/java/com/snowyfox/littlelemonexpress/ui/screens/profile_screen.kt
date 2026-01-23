package com.snowyfox.littlelemonexpress.ui.screens

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.snowyfox.littlelemonexpress.R
import com.snowyfox.littlelemonexpress.ui.navigation.screens.Screens
import com.snowyfox.littlelemonexpress.ui.theme.ButtonYellow
import com.snowyfox.littlelemonexpress.ui.theme.DarkGreens
import com.snowyfox.littlelemonexpress.ui.theme.LightGreens
import com.snowyfox.littlelemonexpress.ui.viewmodels.OnboardingViewModel
import com.snowyfox.littlelemonexpress.utility.isValidEmail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController, viewModel: OnboardingViewModel) {

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
        if (isFocused) {
            scrollState.animateScrollTo(scrollState.maxValue, tween(500))
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.littlelemon_logo),
                                contentDescription = "App Logo",
                                modifier = Modifier.size(140.dp)
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->

            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.1f)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 10.dp)
                            .background(color = MaterialTheme.colorScheme.background),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Personal information",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(start = 32.dp)
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .imePadding()
                        .verticalScroll(scrollState)
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .height(64.dp)
                            .focusRequester(focusRequester),
                        value = firstName,
                        onValueChange = { firstName = it },
                        label = {
                            Text(
                                "First Name",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Light,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        },
                        placeholder = {
                            Text(
                                "please enter a first name",
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        textStyle = LocalTextStyle.current.copy(fontSize = 12.sp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = DarkGreens,
                            unfocusedBorderColor = LightGreens,
                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .height(64.dp)
                            .focusRequester(focusRequester),
                        value = lastName,
                        onValueChange = { lastName = it },
                        label = {
                            Text(
                                "Last Name",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Light,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        },
                        placeholder = { Text("please enter a your last name") },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        textStyle = LocalTextStyle.current.copy(fontSize = 12.sp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = DarkGreens,
                            unfocusedBorderColor = LightGreens,
                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .height(64.dp)
                            .focusRequester(focusRequester),
                        value = email,
                        onValueChange = {
                            email = it
                            isError = it.isValidEmail()
                        },
                        label = {
                            Text(
                                "Email Address",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Light,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        },
                        placeholder = { Text("please enter a valid email address") },
                        isError = isError,
                        singleLine = true,
                        textStyle = LocalTextStyle.current.copy(fontSize = 12.sp),
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Email
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { focusManager.clearFocus() }
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = DarkGreens,
                            unfocusedBorderColor = LightGreens,
                        )
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 40.dp, end = 40.dp, top = 32.dp, bottom = 32.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ButtonYellow,
                            contentColor = LightGreens
                        ),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                        onClick = {
                            viewModel.removeProfile()
                            navController.navigate(Screens.OnBoardingScreen) {
                                popUpTo(Screens.ProfileScreen) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                        }
                    ) {
                        Text(
                            text = "Log out",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }
    }
}