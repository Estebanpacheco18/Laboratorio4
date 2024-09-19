package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
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
        text = { Text(text = "This is the content of the dialog.") },
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
        verticalAlignment = Alignment.CenterVertically.button //.
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
        // Combinar cambios de ambos desarrolladores
         Text(
            text = "Cambio por Desarrollador A y B",
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.Purple)
        )
    }  
      
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MyApplicationTheme {
        MainScreen()
    }
}