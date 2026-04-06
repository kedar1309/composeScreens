package com.example.myapplication.login

import android.graphics.drawable.PaintDrawable
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun LoginScreen(modifier: Modifier, onLoginClick: (String, String) -> Unit ){
    var username = rememberSaveable  {mutableStateOf("") }
    var password = rememberSaveable { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()){
        // Background image
            Image(contentDescription = null,
                painter = painterResource(R.drawable.login_background),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        Column(modifier = Modifier.fillMaxSize().padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            // Welcome text
            Text("Welcome Back !", color = Color.White,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(8.dp))
            // Login Text
            Text("Login to continue", color = Color.LightGray)
            Spacer(modifier = Modifier.height(8.dp))
            // Username Field
            OutlinedTextField(value = username.value,
                onValueChange = {username.value= it},
                label = { Text("Enter username", color = Color.White)},
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White
                ))
            Spacer(modifier = Modifier.height(8.dp))
            // Password Field
            OutlinedTextField(value = password.value,
                onValueChange = {password.value= it},
                visualTransformation = PasswordVisualTransformation(),// hide password
                label = { Text("Enter password", color = Color.White)} ,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White
                ))
            Spacer(modifier = Modifier.height(8.dp))

            // Button to login
           Button(onClick = {onLoginClick(username.value, password.value)},
               shape = RoundedCornerShape(12.dp)){
               Text(text = "Login", color = Color.White)
           }
            Spacer(modifier = Modifier.height(16.dp))
            // text forgot password
            Text("Forgot password", color = Color.LightGray,
                modifier = Modifier.clickable { /* navigate */ })
        }
    }
}




