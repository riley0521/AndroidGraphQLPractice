package com.rpfcoding.androidgraphqlpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rpfcoding.androidgraphqlpractice.ui.theme.AndroidGraphQLPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidGraphQLPracticeTheme {
            }
        }
    }
}