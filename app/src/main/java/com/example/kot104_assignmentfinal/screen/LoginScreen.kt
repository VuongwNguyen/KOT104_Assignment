package com.example.kot104_assignmentfinal.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.kot104_assignmentfinal.R
import com.example.kot104_assignmentfinal.ui.theme.BlackColor
import com.example.kot104_assignmentfinal.ui.theme.GreyColor
import com.example.kot104_assignmentfinal.ui.theme.PrimaryColor
import com.example.kot104_assignmentfinal.ui.theme.WhiteColor

class LoginScreen {
    @Composable
    fun Container(modifier: Modifier = Modifier) {
        val ctxt = LocalContext.current
        var emailTF by rememberSaveable { mutableStateOf("") }
        var passwordTF by rememberSaveable { mutableStateOf("") }
        Column(
            modifier = Modifier.fillMaxSize()
                .background(WhiteColor),

            ) {
            HeadersLogin()
            Text(
                text = "Hello!",
                modifier = Modifier.padding(horizontal = 30.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Welcome back".uppercase(),
                modifier = Modifier.padding(horizontal = 30.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.size(60.dp))
            Box(
                modifier = Modifier
                    .padding(end = 30.dp)
                    .shadow(elevation = 30.dp)
                    .background(WhiteColor),

                ) {
                Column {
                    TextFieldCP(
                        holder = "Email",
                        value = emailTF,
                        onValueChange = { emailTF = it },
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    TextFieldCP(
                        holder = "Password",
                        value = passwordTF,
                        onValueChange = { passwordTF = it },
                        isPassword = true
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        text = "Forgot Password?",
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.labelSmall,
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    ButtonCP(title = "Log in") {

                    }



                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        text = "Sign up",
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.labelSmall,
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                }


            }
        }
    }


}

@Composable
fun ButtonCP(title: String, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryColor,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(50.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
            color = WhiteColor
        )
    }
}

@Composable
fun TextFieldCP(
    holder: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false
) {
    // Use remember and mutableStateOf to manage the state of password visibility
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        keyboardOptions =
        if (isPassword) KeyboardOptions(keyboardType = KeyboardType.Password)
        else KeyboardOptions.Default,
        visualTransformation =
        if (isPassword && !passwordVisible) PasswordVisualTransformation()
        else VisualTransformation.None,
        trailingIcon = {
            if (isPassword) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_eye),
                    contentDescription = if (passwordVisible) "Hide password" else "Show password",
                    modifier = Modifier.clickable { passwordVisible = !passwordVisible }
                )
            }
        },
        label = {
            Text(
                text = holder,
                color = GreyColor
            )
        },
        colors = TextFieldDefaults.colors(
            cursorColor = BlackColor,
            unfocusedContainerColor = WhiteColor,
            focusedContainerColor = WhiteColor,
            focusedIndicatorColor = GreyColor,
            unfocusedIndicatorColor = GreyColor,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp)
    )
}


@Composable
fun HeadersLogin() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .fillMaxWidth()
                .background(BlackColor)
        )
        Image(
            painter = painterResource(id = R.drawable.icon_chair),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .padding(8.dp)
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
                .background(BlackColor)
                .height(1.dp)
                .fillMaxWidth()
        )
    }
}