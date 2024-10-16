package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SubjectDetailScreen(
    subjectName: String,
    navController: NavController
) {
    // Datos de ejemplo para las calificaciones de los parciales
    val partialGrades = listOf(9.0, 8.5, 9.2)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Nombre de la materia
        Text(
            text = "Materia: $subjectName",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Calificaciones de los parciales
        partialGrades.forEachIndexed { index, grade ->
            Text(
                text = "Parcial ${index + 1}: $grade",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}
