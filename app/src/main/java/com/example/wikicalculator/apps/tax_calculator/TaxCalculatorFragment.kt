package com.example.wikicalculator.apps.tax_calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.wikicalculator.core.model.Padding
import com.example.wikicalculator.ui.RadicalShaderBrush
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaxCalculatorFragment : Fragment() {

    private val viewModel by viewModels<TaxCalculatorViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    TaxCalculatorFragmentScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(RadicalShaderBrush())
                            .padding(it)
                            .verticalScroll(rememberScrollState()), // careful here, use it in parent level
                    )
                }
            }
        }
    }

    @Composable
    private fun TaxCalculatorFragmentScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Padding.paddingM),
        ) {
            TaxCalculatorScreen(
                onIncomeInputRowDataChanged = viewModel::onIncomeInputRowDataChanged,
                user1TaxInfo = viewModel.user1,
                user2TaxInfo = viewModel.user2,
                onAddMoreIncomeButtonClick = viewModel::onAddMoreIncomeButtonClick,
                onCalculateClick = viewModel::clickCalculateButton,
                calculatedResult = viewModel.calculatedResult,
                currentUserId = viewModel.currentUserId,
                onBackButtonClick = viewModel::switchToUser1,
                onNextButtonClick = viewModel::switchToUser2,
                onResultDismissButtonClicked = viewModel::onResultDismissButtonClicked,
                isShowingResult = viewModel.isShowingResult,
            )
        }

    }
}