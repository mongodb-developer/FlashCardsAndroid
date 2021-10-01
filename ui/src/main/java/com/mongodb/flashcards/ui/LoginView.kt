package com.mongodb.flashcards.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mongodb.flashcards.ui.theme.FlashCardsTheme
import com.mongodb.flashcards.ui.viewmodels.LoginViewModel

@Composable
fun LoginView(viewModel: LoginViewModel = LoginViewModel()) {
    // <editor-fold desc="State">
    var userName by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val buttonEnabled by viewModel.buttonEnabled.observeAsState(false)
    // </editor-fold>

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Login",
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h1
        )
        OutlinedTextField(
            value = userName,
            onValueChange = { newUserName ->
                userName = newUserName
                viewModel.onCredentialsChanged(userName = userName, password = password)
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "User Name") }
        )
        OutlinedTextField(
            value = password,
            onValueChange = { newPassword ->
                password = newPassword
                viewModel.onCredentialsChanged(userName = userName, password = password)
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Button(
            onClick = {
                if (viewModel.login(userName, password)) {
                    print("Logged in")
                }
            },
            modifier = Modifier.align(Alignment.End),
            enabled = buttonEnabled
        ) {
            Text(
                text = "Submit"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginViewPreview() {
    FlashCardsTheme {
        LoginView()
    }
}
