package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import androidx.navigation.compose.rememberNavController


@Composable
fun SettingsScreen(innerPadding: PaddingValues, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen circular del alumno
        Image(
            painter = rememberAsyncImagePainter("https://www.example.com/imagen_alumno.jpg"), // Reemplaza con una URL o ruta válida
            contentDescription = "Foto del alumno",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Información del alumno
        Text("Nombre completo: Juan Pérez López", style = MaterialTheme.typography.bodyMedium)
        Text("Fecha de nacimiento: 01/01/2000", style = MaterialTheme.typography.bodyMedium)
        Text("Correo institucional: juan.perez@universidad.edu", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(24.dp))

        // Lista de opciones
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OptionItem("Cambiar contraseña", onClick = {
                navController.navigate("change_password")
            })
            OptionItem("Cambiar tema de la aplicación", onClick = {
                navController.navigate("change_theme")
            })
        }
    }
}

@Composable
fun OptionItem(title: String, onClick: () -> Unit) {
    Text(
        text = title,
        style = MaterialTheme.typography.bodyLarge,
        color = Color.Blue,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 8.dp)
    )
}

@Preview
@Composable
fun PreviewSettingsScreen() {
    SettingsScreen(innerPadding = PaddingValues(), navController = rememberNavController())
}
