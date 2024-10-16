package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a512lasalleapp.R
import com.example.a512lasalleapp.ui.utils.Check_circle
import com.example.a512lasalleapp.ui.utils.CrossCircled

@Composable
fun PaymentsScreen(navController: NavController) {
    // Lista de meses y su estado de pago
    val payments = listOf(
        "Enero" to false,
        "Febrero" to false,
        "Marzo" to false,
        "Abril" to false,
        "Mayo" to false,
        "Junio" to true,
        "Julio" to true,
        "Agosto" to true,
        "Septiembre" to true,
        "Octubre" to true,
        "Noviembre" to false,
        "Diciembre" to false
    )

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text(text = "Pagos", style = MaterialTheme.typography.headlineMedium)

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(payments) { (month, isPaid) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { /* Acción al hacer clic en un mes, si es necesario */ }
                ) {
                    Text(
                        text = month,
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Icon(
                        imageVector = if(isPaid) CrossCircled else  Check_circle,
                        contentDescription = if (isPaid) "Pagado" else "Pendiente",
                        tint = if(isPaid) Color.Green else Color.Red
                    )
                }
            }
        }
    }
}
