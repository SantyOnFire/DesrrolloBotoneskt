package com.example.navegacionentreventanas.screen.nav

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ScreenC(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla C")

        Button(
            onClick = { navController.navigate("screen_a") },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Ir a Pantalla A")
        }

        Button(
            onClick = {

                navController.navigate("screen_b/Juan/juan@mail.com/Ingeniero")
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Ir a Pantalla B (con datos)")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenCPreview() {
    val navController = rememberNavController()
    ScreenC(navController = navController)
}
