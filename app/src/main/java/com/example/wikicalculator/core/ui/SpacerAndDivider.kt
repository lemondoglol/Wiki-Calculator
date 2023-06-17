package com.example.wikicalculator.core.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.example.wikicalculator.core.model.Padding
import com.example.wikicalculator.core.model.Size

@Composable
fun HorizontalSpacerAndDivider(
    paddingSize: Dp = Padding.paddingS,
    dividerThickness: Dp = Size.dividerSize,
) {
    Spacer(modifier = Modifier.height(paddingSize))
    Divider(thickness = dividerThickness)
    Spacer(modifier = Modifier.height(paddingSize))
}

@Composable
fun VerticalSpacer(
    paddingSize: Dp = Padding.paddingS,
) {
    Spacer(modifier = Modifier.height(paddingSize))
}

@Composable
fun HorizontalSpacer(
    paddingSize: Dp = Padding.paddingS,
) {
    Spacer(modifier = Modifier.width(paddingSize))
}