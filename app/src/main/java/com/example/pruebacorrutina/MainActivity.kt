package com.example.pruebacorrutina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface {
                Interfaz()
            }
        }
    }
}

@Composable
fun Interfaz() {
    val tarea = remember { mutableStateOf("Esperando a realizar la tarea") }
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Button(onClick = {
            coroutineScope.launch {
                tarea.value = realizarTarea()
            }
        }) {
            Text(text = "Realizar tarea")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Tarea: ${tarea.value}")
    }
}
suspend fun realizarTarea(): String {
    delay(5000)
    return "Realizada"
}