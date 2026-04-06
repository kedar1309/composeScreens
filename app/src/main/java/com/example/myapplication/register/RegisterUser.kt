package com.example.myapplication.register

import android.graphics.drawable.PaintDrawable
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R


@Composable
fun RegisterUser(modifier: Modifier) {

    var username = rememberSaveable() { mutableStateOf("") }
    var email = rememberSaveable() {mutableStateOf("") }
    var address = rememberSaveable() {mutableStateOf("") }
    var phonenumber = rememberSaveable { mutableStateOf("")}
    var context = LocalContext.current

    Box(modifier= Modifier.fillMaxSize()){

        Image(modifier= modifier.fillMaxSize(),
            contentDescription =  null,
            contentScale = ContentScale.Crop,
            painter = painterResource(R.drawable.login_background))

        Column(modifier= Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "Register User", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(modifier= Modifier.height(8.dp))
            OutlinedTextField(value = username.value,
                modifier= Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp),
                onValueChange = {username.value = it},
                label = {Text(text = "Username")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                ))

            Spacer(modifier= Modifier.height(8.dp))
            OutlinedTextField(value = email.value,
                modifier= Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp),
                onValueChange = {email.value = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
                label = {Text(text = "email")},
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White
                ))

            Spacer(modifier= Modifier.height(8.dp))
            OutlinedTextField(value = address.value,
                modifier= Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp),
                onValueChange = {address.value = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                label = {Text(text = "address")},
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White
                ))

            Spacer(modifier= Modifier.height(8.dp))
            OutlinedTextField(
                modifier= Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp),
                value = phonenumber.value,
                onValueChange = {phonenumber.value = it},
                label = {Text(text = "phonenumber")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    unfocusedSupportingTextColor = Color.White
                ))

            Spacer(modifier= Modifier.height(8.dp))
            Button(onClick = {
                var username = username.value
                var email = email.value
                var phone = phonenumber.value
                var address = address.value
                if(username.isNullOrEmpty() || phone.isNullOrEmpty() ||
                    email.isNullOrEmpty() ){
                    Toast.makeText(context, "Enter all the details", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context, "Registration completed", Toast.LENGTH_LONG).show()
                }
            }) {
                Text("Register user")
            }
        }

    }


}