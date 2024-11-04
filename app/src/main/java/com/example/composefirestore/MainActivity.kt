package com.example.composefirestore

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
import com.example.composefirestore.ui.theme.ComposeFirestoreTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.TextField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Row

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeFirestoreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Birth(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Birth(modifier: Modifier) {
    var userName by remember { mutableStateOf("顧晉瑋") }
    var userWeight by remember { mutableStateOf(0) }
    var userPassword by remember { mutableStateOf("") }
    var msg by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        TextField(
            value = userName,
            onValueChange = { newText ->
                userName = newText
            },
            label = { Text("姓名") },
            placeholder = { Text("請輸入您的姓名") }
        )

        TextField(
            value = userWeight.toString(),
            onValueChange = { newText ->
                userWeight = if (newText == "") 0 else newText.toIntOrNull() ?: 0
            },
            label = { Text("體重") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = userPassword,
            onValueChange = { newText ->
                userPassword = newText
            },
            label = { Text("密碼") },
            placeholder = { Text("請輸入您的密碼") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Text(
            text = "您輸入的姓名是：$userName\n體重是：$userWeight 公斤\n密碼：$userPassword"
        )

        Row {
            Button(onClick = { msg = "送出資料" }) {
                Text(text = "送出資料")
            }

            Button(onClick = { msg = "發送訊息" }) {
                Text(text = "發送訊息")
            }

            Button(onClick = { msg = "電腦資訊" }) {
                Text(text = "電腦資訊")
            }
        }

        Text(text = msg)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBirth() {
    ComposeFirestoreTheme {
        Birth(modifier = Modifier.padding())
    }
}

