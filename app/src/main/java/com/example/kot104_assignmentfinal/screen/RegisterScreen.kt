package com.example.kot104_assignmentfinal.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot104_assignmentfinal.ui.theme.PrimaryColor
import com.example.kot104_assignmentfinal.ui.theme.TheBestColor
import com.example.kot104_assignmentfinal.ui.theme.WhiteColor

class RegisterScreen {
    @Composable
    fun Container() {
        val message = buildAnnotatedString {
            append("Already have account? ")
            withStyle(
                SpanStyle(
                    color = PrimaryColor,
                    fontWeight = FontWeight(700),
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Normal
                )
            ) {
                append("Sign in".uppercase())
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(WhiteColor)
        ) {
            Column {
                HeadersLogin()
                Text(
                    text = "Welcome".uppercase(),
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
                            holder = "Name",
                            value = "",
                            onValueChange = { },
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        TextFieldCP(
                            holder = "Email",
                            value = "",
                            onValueChange = { },

                            )
                        Spacer(modifier = Modifier.size(20.dp))
                        TextFieldCP(
                            holder = "Password",
                            value = "",
                            onValueChange = { },
                            isPassword = true
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        TextFieldCP(
                            holder = "Confirm Password",
                            value = "",
                            onValueChange = { },
                            isPassword = true
                        )
                        Spacer(modifier = Modifier.size(20.dp))


                        Spacer(modifier = Modifier.size(20.dp))
                        ButtonCP(title = "Sign up") {


                        }
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(
                            text = message,
                            modifier = Modifier
                                .padding(end = 20.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.labelSmall,
                            fontSize = 14.sp,
                            color = TheBestColor
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                    }


                }
            }
        }
    }
}