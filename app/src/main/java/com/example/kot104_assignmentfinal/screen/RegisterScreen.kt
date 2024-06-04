package com.example.kot104_assignmentfinal.screen


import android.widget.Toast
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot104_assignmentfinal.helper.RetrofitAPI
import com.example.kot104_assignmentfinal.httpModel.RegisterRequestModel
import com.example.kot104_assignmentfinal.httpModel.RegisterResponseModel
import com.example.kot104_assignmentfinal.ui.theme.PrimaryColor
import com.example.kot104_assignmentfinal.ui.theme.TheBestColor
import com.example.kot104_assignmentfinal.ui.theme.WhiteColor

class RegisterScreen {
    @Composable
    fun Container(goTo:(String) -> Unit) {
        val ctxt = LocalContext.current
        var username by remember { mutableStateOf("Another user") }
        var email by remember { mutableStateOf("nguyen1345@gmail.com") }
        var phone by remember { mutableStateOf("05221125445") }
        var password by remember { mutableStateOf("123456789") }
        var confirmPassword by remember { mutableStateOf("123456789") }

        fun registerCallBack(response: RegisterResponseModel) {
            if (response.status) {
                Toast.makeText(ctxt, "Register success", Toast.LENGTH_SHORT).show()
                Toast.makeText(ctxt, "Welcome ${response.user?.username}", Toast.LENGTH_SHORT).show()
                println(response.user)
                goTo("loginScreen")
            } else {
                Toast.makeText(ctxt, "Register failed", Toast.LENGTH_SHORT).show()
            }
        }


        fun onClickRegister() {
//            validation check
            if (password != confirmPassword) {
                println("password not match")
                return
            }
            val user = RegisterRequestModel(
                username = username,
                email = email,
                phone = phone,
                password = password
            )
            try {
                val api = RetrofitAPI()
                api.registerUser(user) {
                    if (it != null) {
                        registerCallBack(it)
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(ctxt, "failed to register", Toast.LENGTH_SHORT).show()

            }

        }

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
                            holder = "Phone Number",
                            value = phone,
                            onValueChange = { phone = it },
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        TextFieldCP(
                            holder = "Email",
                            value = email,
                            onValueChange = { email = it },
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        TextFieldCP(
                            holder = "Password",
                            value = password,
                            onValueChange = { password = it },
                            isPassword = true
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        TextFieldCP(
                            holder = "Confirm Password",
                            value = confirmPassword,
                            onValueChange = { confirmPassword = it },
                            isPassword = true
                        )
                        Spacer(modifier = Modifier.size(20.dp))


                        Spacer(modifier = Modifier.size(20.dp))
                        ButtonCP(title = "Sign up") { onClickRegister() }
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