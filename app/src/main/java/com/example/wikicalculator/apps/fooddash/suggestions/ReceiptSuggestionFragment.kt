package com.example.wikicalculator.apps.fooddash.suggestions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.wikicalculator.apps.fooddash.FoodDashFragmentViewModel
import com.example.wikicalculator.ui.RadicalShaderBrush
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReceiptSuggestionFragment : Fragment() {

    private val viewModel by viewModels<FoodDashFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ReceiptSuggestionFragmentScreen(
                        modifier = Modifier.fillMaxSize().background(RadicalShaderBrush())
                    )
                }
            }
        }
    }

    @Composable
    private fun ReceiptSuggestionFragmentScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MainScreen(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

