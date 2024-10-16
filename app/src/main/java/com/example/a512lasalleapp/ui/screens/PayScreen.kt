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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Pagos",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Cuerpo de la pantalla con la lista de pagos
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                items(payments) { (month, isPaid) ->
                    PaymentItem(
                        month = month,
                        isPaid = isPaid,
                        onClick = {
                            // Acción al hacer clic en un mes
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun PaymentItem(month: String, isPaid: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = month,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
            Icon(
                imageVector = if (isPaid) Check_circle else CrossCircled,
                contentDescription = if (isPaid) "Pagado" else "Pendiente",
                tint = if (isPaid) Color.Green else Color.Red,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun PaymentsScreenPreview() {
    val navController = rememberNavController()
    PaymentsScreen(navController = navController)
}
