package com.rpfcoding.androidgraphqlpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.rpfcoding.androidgraphqlpractice.presentation.CountriesScreen
import com.rpfcoding.androidgraphqlpractice.presentation.CountriesViewModel
import com.rpfcoding.androidgraphqlpractice.ui.theme.AndroidGraphQLPracticeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidGraphQLPracticeTheme {
                val viewModel: CountriesViewModel = hiltViewModel()
                val state by viewModel.state.collectAsState()

                CountriesScreen(
                    state = state,
                    onSelectCountry = viewModel::selectCountry,
                    onDismissCountryDialog = viewModel::dismissCountryDialog
                )
            }
        }
    }
}