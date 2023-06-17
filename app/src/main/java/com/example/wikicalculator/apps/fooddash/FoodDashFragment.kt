package com.example.wikicalculator.apps.fooddash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wikicalculator.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodDashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        // TODO give some image
                        Button(
                            onClick = {
                                findNavController().navigate(
                                    FoodDashFragmentDirections.actionFoodDashFragmentToReceiptSuggestionFragment()
                                )
                            }
                        ) {
                            Text(context.getString(R.string.give_me_some_surprise))
                        }

                        Button(
                            onClick = {
                                findNavController().navigate(
                                    FoodDashFragmentDirections.actionFoodDashFragmentToWhatWeCanMakeFragment()
                                )
                            }
                        ) {
                            Text(context.getString(R.string.lets_see_what_we_can_make))
                        }
                    }
                }
            }
        }
    }

}