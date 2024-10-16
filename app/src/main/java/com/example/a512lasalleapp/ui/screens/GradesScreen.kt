package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
@Composable
fun GradesScreen(
    innerPadding: PaddingValues,
    navController: NavController
) {
    // Datos de ejemplo
    val studentName = "Yef Rueda"
    val career = "Ingeniería de Software y Sistemas"
    val semester = "5to Semestre"
    val accumulatedAverage = 9.1
    val subjects = listOf(
        "Modelado de imágenes" to 9.0,   // Convertimos los enteros a Double
        "Cristianismo 💀" to 8.5,
        "Base de Datos" to 9.3,
        "Taller desarrollo Android" to 10.0,  // Aquí también
        "Redes de área local" to 8.9
    )

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
                .height(200.dp)
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                Text(
                    text = "Calificaciones",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = studentName,
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = career,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text = semester,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Información de promedio acumulado
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Promedio acumulado: $accumulatedAverage",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Lista de materias con calificaciones
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                items(subjects) { (subject, average) ->
                    SubjectGradeItem(
                        subject = subject,
                        average = average,
                        onClick = {
                            navController.navigate("subject_detail/${subject.replace(" ", "_")}")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun SubjectGradeItem(subject: String, average: Double, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(12.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = subject,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = average.toString(),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview
@Composable
fun GradesScreenPreview() {
    val navController = rememberNavController()
    GradesScreen(innerPadding = PaddingValues(), navController = navController)
}