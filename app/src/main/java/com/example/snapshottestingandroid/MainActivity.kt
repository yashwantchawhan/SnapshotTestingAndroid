package com.example.snapshottestingandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bankdashboard.BankDashboardSimpleScreen
import com.example.snapshottestingandroid.ui.theme.SnapshotTestingAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnapshotTestingAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BankDashboardSimpleScreen(
                      modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        Text(
            text = "New Text",
            modifier = modifier.background(color = MaterialTheme.colorScheme.tertiary)
        )

        Text(
            text = "Error text",
            modifier = modifier.background(color = MaterialTheme.colorScheme.error)
        )

        Text(
            text = "Error text",
            modifier = modifier.background(color = MaterialTheme.colorScheme.primary)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnapshotTestingAndroidTheme {
        Greeting("Android")
    }
}