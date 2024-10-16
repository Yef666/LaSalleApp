package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.a512lasalleapp.ui.components.ScreenTemplate

@Composable
fun GradesScreen(
    innerPadding: PaddingValues,
    navController: NavController
) {
    // Datos de ejemplo
    val studentName = "Juan Pérez"
    val career = "Ingeniería en Sistemas"
    val semester = "5to Semestre"
    val accumulatedAverage = 9.2
    val subjects = listOf(
        "Matemáticas Avanzadas" to 8.5,
        "Programación Avanzada" to 9.0,
        "Base de Datos" to 9.3,
        "Redes de Computadoras" to 8.8
    )

    ScreenTemplate(innerPadding = innerPadding, header = {
        Text(
            text = "Calificaciones",
            style = MaterialTheme.typography.headlineMedium
        )
    }, body = {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Información del alumno
            Text(text = "Nombre: $studentName", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Carrera: $career", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Semestre: $semester", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Promedio acumulado: $accumulatedAverage", style = MaterialTheme.typography.bodyLarge)

            // Lista de materias
            LazyColumn(modifier = Modifier.fillMaxWidth().height(200.dp)) {
                items(subjects) { (subject, average) ->
                    Text(
                        text = "$subject: $average",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                // Navegar a la pantalla de detalles de la materia
                                navController.navigate("subject_detail/${subject.replace(" ", "_")}")
                            },
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    })
}

@Preview
@Composable
fun GradesScreenPreview() {
    val navController = rememberNavController()
    GradesScreen(innerPadding = PaddingValues(), navController = navController)
}
