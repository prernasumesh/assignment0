package com.example.decisionmakingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decisionmakingapp.ui.theme.DecisionMakingAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DecisionMakingAppTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) {
                    DecisionApp()
                }
            }
        }
    }
}

@Composable
fun DecisionApp() {
    var clicks by remember() { mutableIntStateOf(0) }
    var decision by remember { mutableStateOf("Should we go?") }

    fun rollOk(){
        decision = if(Random.nextFloat() < 0.5f) "Yes" else "No"
        clicks++
    }

    fun rollMeh(){
        decision = if(Random.nextFloat() < 0.25f) "Yes" else "No"
        clicks++
    }

    fun rollNah(){
        decision = if(Random.nextFloat() < 0.1f) "Yes" else "No"
        clicks++
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(decision, fontSize = 20.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = { rollOk() }) {
                Text("Ok")
            }

            Button(onClick = { rollMeh() }) {
                Text("Meh")
            }

            Button(onClick = { rollNah() }) {
                Text("Nah")
            }
        }
        Text("Clicks: $clicks")
        Text("ID: 1872648    CCID: psumesh")
    }
}