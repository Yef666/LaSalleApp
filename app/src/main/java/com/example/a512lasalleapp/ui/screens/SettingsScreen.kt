package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import androidx.navigation.compose.rememberNavController
import com.example.a512lasalleapp.R

@Composable
fun SettingsScreen(innerPadding: PaddingValues, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp))
                .height(270.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Background Image",
                modifier = Modifier
                    .fillMaxSize()
                    .offset(y = 70.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(70.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 15.dp)
                    )
                }

            }
        }

        // Espaciado
        Spacer(modifier = Modifier.height(16.dp))

        // Imagen circular del alumno
        Image(
            painter = rememberAsyncImagePainter("https://i.pinimg.com/280x280_RS/05/90/41/0590412eb289af7a0636b9c336cba325.jpg"),
            contentDescription = "Foto del alumno",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp)) // Cambiar tamaño del espacio

        // Información del alumno
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Text(
                "Nombre completo: Yef Rueda Ayala",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
            Text(
                "Fecha de nacimiento: 06/05/2002",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
                color = Color.Gray
            )
            Text(
                "Correo institucional: yra76123@lasallebajio.edu.mx",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Lista de opciones
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            OptionItem("Cambiar contraseña", onClick = {
                navController.navigate("change_password")
            })
            OptionItem("Cambiar tema de la aplicación", onClick = {
                navController.navigate("change_theme")
            })
            OptionItem("Cerrar sesión", onClick = {
                // Acción de cerrar sesión
            })
        }
    }
}

@Composable
fun OptionItem(title: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .clickable { onClick() }
            .padding(vertical = 16.dp, horizontal = 24.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
fun PreviewSettingsScreen() {
    SettingsScreen(innerPadding = PaddingValues(), navController = rememberNavController())
}
