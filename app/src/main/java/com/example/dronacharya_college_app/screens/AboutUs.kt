package com.example.dronacharya_college_app.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AboutUs() {
    Text(text = "AboutUs",modifier = Modifier
        .fillMaxSize()
        .padding(top = 450.dp), style = TextStyle(textAlign = TextAlign.Center))
}

@Preview(showBackground = true)
@Composable
fun Prev_AboutUs(){
    AboutUs()
}