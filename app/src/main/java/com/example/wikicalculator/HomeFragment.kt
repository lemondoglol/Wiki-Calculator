package com.example.wikicalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wikicalculator.core.model.Dimens
import com.example.wikicalculator.core.model.Padding
import com.example.wikicalculator.ui.RadicalShaderBrush
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {

                    }
                ) {
                    HomeFragmentScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(RadicalShaderBrush())
                            .padding(Padding.paddingM)
                    )
                }
            }
        }
    }

    @Composable
    private fun HomeFragmentScreen(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier,
        ) {
            Image(
                modifier = Modifier
                    .size(Dimens.iconSize)
                    .clickable {
                        val action =
                            HomeFragmentDirections.actionHomeFragmentToTaxCalculatorFragment()
                        findNavController().navigate(action)
                    },
                painter = painterResource(R.drawable.ic_tax_svgrepo_com),
                contentDescription = stringResource(R.string.tax_calculator)
            )
        }
    }

}
