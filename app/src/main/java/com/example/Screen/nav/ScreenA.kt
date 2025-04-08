package com.example.navegacionentreventanas.screen.nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navegacionentreventanas.listaDatos

@Composable
fun ScreenA(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var profesion by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(Color(0xFFBBDEFB), Color(0xFFE3F2FD))
                )
            )
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Filled.Person, contentDescription = null, tint = Color(0xFF1565C0), modifier = Modifier.size(64.dp))
        Spacer(modifier = Modifier.height(12.dp))
        Text("Formulario de Registro", fontSize = 24.sp, color = Color(0xFF1565C0))

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it; error = false },
            label = { Text("Nombre") },
            isError = error && nombre.isBlank(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it; error = false },
            label = { Text("Correo") },
            isError = error && correo.isBlank(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = profesion,
            onValueChange = { profesion = it; error = false },
            label = { Text("Profesión") },
            isError = error && profesion.isBlank(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {
                if (nombre.isNotBlank() && correo.isNotBlank() && profesion.isNotBlank()) {
                    listaDatos.add(Triple(nombre, correo, profesion))
                    navController.navigate("screen_b/${nombre}/${correo}/${profesion}")
                } else {
                    error = true
                }
            }) {
                Icon(Icons.Filled.ArrowForward, contentDescription = "Guardar", tint = Color(0xFF2E7D32))
            }

            IconButton(onClick = { navController.navigate("screen_c") }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Lista", tint = Color(0xFF1565C0))
            }
        }
    }
}
