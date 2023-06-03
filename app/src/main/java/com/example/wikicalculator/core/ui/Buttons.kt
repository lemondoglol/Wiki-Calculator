package com.example.wikicalculator.core.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

/**
ButtonWithIcon(
    onClick = {
        onAddMoreIncomeButtonClick(userTaxInfo.userId)
    },
    text = stringResource(R.string.Add_More_Income),
)
 * */
@Composable
fun ButtonWithIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    iconSize: Dp =  ButtonDefaults.IconSize,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
    ) {
        Icon(
            modifier = Modifier.size(iconSize),
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = text)
    }
}