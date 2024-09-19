package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio4Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MyDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Dialog Title") },
        text = { Text(text = "This is the Stivie Pacheco") },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("OK")
            }
        }
    )
}

@Composable
fun MainScreen() {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        MyDialog(onDismiss = { showDialog = false })
    }

    Scaffold(
        floatingActionButton = {
            Button(onClick = { showDialog = true }) {
                Text("Show Dialog")
            }
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                items(20) { index ->
                    ListItem(index)
                }
            }
        }
    )
}

@Composable
fun ListItem(index: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Star Icon",
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = "Item #$index",
            style = MaterialTheme.typography.bodyLarge
        )
         // Cambio por Desarrollador A
        Text(
            text = "Cambio por Desarrollador A",
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.Red)
        )
    }  
      
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Laboratorio4Theme {
        MainScreen()
    }
}