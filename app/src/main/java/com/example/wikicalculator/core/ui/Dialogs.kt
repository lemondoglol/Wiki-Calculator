package com.example.wikicalculator.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.wikicalculator.R
import com.example.wikicalculator.core.model.Padding

@Composable
fun CustomDialog(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
    isDialogClicked: Boolean = false,
    onDismissButtonClicked: () -> Unit = {},
) {
    if (isDialogClicked) {
        AlertDialog(
            onDismissRequest = {
                onDismissButtonClicked()
            },
            title = {
                Text(title)
            },
            text = {
                Text(text = content)
            },
            buttons = {
                Row(
                    modifier = Modifier.padding(Padding.paddingS),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            onDismissButtonClicked()
                        }
                    ) {
                        Text(stringResource(R.string.dismiss))
                    }
                }
            }
        )
    }
}