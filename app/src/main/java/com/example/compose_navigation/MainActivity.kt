package com.example.compose_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_navigation.ui.theme.Compose_NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_NavigationTheme {
                NavigationComposable()
            }
        }
    }
}

@Composable
fun NavigationComposable() {
    val navController = rememberNavController()
    NavHost(navController = navController,  startDestination = "screen1") {
        composable("screen1") { Screen1(navController) }
        composable("screen2") { Screen2(navController) }
    }
}

@Composable
fun Screen2(navController: NavController) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)){
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .width(120.dp)
                .height(36.dp)
                .clickable(indication = null, interactionSource = interactionSource) {
                    navController.navigate("screen1")
                }
                .background(shape = RoundedCornerShape(100.dp), color = Color.Yellow),
        )
    }
}

@Composable
fun Screen1(navController: NavController) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Green)){
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .width(120.dp)
                .height(36.dp)
                .clickable(indication = null, interactionSource = interactionSource) {
                    navController.navigate("screen2")
                }
                .background(shape = RoundedCornerShape(100.dp), color = Color.Red)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_NavigationTheme {
    }
}