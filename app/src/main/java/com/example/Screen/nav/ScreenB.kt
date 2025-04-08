package com.example.navegacionentreventanas.screen.nav

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ScreenB(navController: NavController, nombre: String, correo: String, profesion: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla B")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Nombre: $nombre")
        Text(text = "Correo: $correo")
        Text(text = "Profesión: $profesion")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("screen_a") },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Volver a Pantalla A")
        }

        Button(
            onClick = { navController.navigate("screen_c") },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Ir a Pantalla C")
        }
    }
}
