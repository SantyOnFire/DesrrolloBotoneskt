package com.example.navegacionentreventanas.screen.nav

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navegacionentreventanas.listaDatos

@Composable
fun ScreenC(navController: NavController) {
    val seleccionados = remember { mutableStateListOf<Int>() }
    var mostrarDialogo by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "📋 Historial de Registros",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (listaDatos.isEmpty()) {
            Text("No hay registros aún.", style = MaterialTheme.typography.bodyLarge)
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                itemsIndexed(listaDatos) { index, item ->
                    val seleccionado = seleccionados.contains(index)

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                if (seleccionado) seleccionados.remove(index) else seleccionados.add(index)
                            },
                        colors = CardDefaults.cardColors(
                            containerColor = if (seleccionado) Color(0xFFFFCDD2)
                            else MaterialTheme.colorScheme.secondaryContainer
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("👤 Nombre: ${item.first}")
                            Text("📧 Correo: ${item.second}")
                            Text("💼 Profesión: ${item.third}")
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = { navController.navigate("screen_a") }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Volver")
            }

            Button(
                onClick = { if (seleccionados.isNotEmpty()) mostrarDialogo = true },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFCDD2))
            ) {
                Icon(Icons.Filled.Delete, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Eliminar")
            }
        }

        if (mostrarDialogo) {
            AlertDialog(
                onDismissRequest = { mostrarDialogo = false },
                title = { Text("¿Confirmar eliminación?") },
                text = { Text("¿Deseas eliminar los registros seleccionados?") },
                confirmButton = {
                    TextButton(onClick = {
                        seleccionados.sortedDescending().forEach { listaDatos.removeAt(it) }
                        seleccionados.clear()
                        mostrarDialogo = false
                    }) {
                        Text("Sí")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { mostrarDialogo = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}


