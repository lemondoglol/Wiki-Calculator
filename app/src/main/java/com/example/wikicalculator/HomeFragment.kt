package com.example.wikicalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

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
                        modifier = Modifier.fillMaxSize().padding(it)
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.icon_48))
                    .clickable {
                    val action = HomeFragmentDirections.actionHomeFragmentToTaxCalculatorFragment()
                    findNavController().navigate(action)
                },
                painter = painterResource(R.drawable.ic_tax_svgrepo_com),
                contentDescription = stringResource(R.string.tax_calculator)
            )
        }
    }

}
