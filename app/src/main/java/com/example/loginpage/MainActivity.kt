package com.example.loginpage

import android.widget.Toast
import android.widget.Toast.makeText
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.ui.theme.Pink40
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val isPasswordVisible = remember { mutableStateOf(false) }
    var context = LocalContext.current.applicationContext

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.myloginbg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        // Background layer with blur effect
        Box(
            modifier = Modifier

                .clip(RoundedCornerShape(20.dp))
                .background(color = Color.White.copy(alpha = 0.2f))
                .blur(radius = 10.dp)
                .height(400.dp)
                .width(300.dp)
                .align(Alignment.Center)
        )

        // Foreground content without blur
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(color = Color.Transparent)
                .height(400.dp)
                .width(300.dp)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "LOGIN PAGE",
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                letterSpacing = 6.sp,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                label = { Text(text = "Username") },
                modifier = Modifier.width(250.dp),
                value = username.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                onValueChange = { username.value = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                label = { Text(text = "Password") },
                modifier = Modifier.width(250.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedTrailingIconColor = Color.Black,
                    unfocusedTrailingIconColor = Color.Black
                ),
                value = password.value,
                onValueChange = { password.value = it },
                visualTransformation = if (isPasswordVisible.value) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    Icon(
                        imageVector = if (isPasswordVisible.value) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = "Toggle password visibility",
                        tint = Color.Black,
                        modifier = Modifier.clickable { isPasswordVisible.value = !isPasswordVisible.value }
                    )
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = Pink40.copy(alpha = 0.8f))
                    .width(100.dp)
                    .height(50.dp)
                    .clickable {Toast.makeText(context,"Login Clicked",Toast.LENGTH_SHORT).show()}
            ) {
                Text(text = "LOGIN")
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Forgot Password?",
                fontStyle = FontStyle.Italic,
                letterSpacing = 3.sp,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .clickable {Toast.makeText(context,"Forgot Password Clicked",Toast.LENGTH_SHORT).show() }
            )
            Text(
                text = "Or Sign Up Here...",
                fontSize = 13.sp,
                fontStyle = FontStyle.Italic,
                letterSpacing = 3.sp,
                modifier = Modifier.clickable {Toast.makeText(context,"Sign up Clicked",Toast.LENGTH_SHORT).show() }
            )
        }
    }
}

@Preview
@Composable
fun SeeLogin() {
    Login()
}
