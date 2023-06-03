package com.example.wikicalculator.core.ui

import android.icu.util.UniversalTimeScale.toBigDecimal
import android.util.Log
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import com.example.wikicalculator.core.model.FontSize
import java.text.DecimalFormat

/**
 * Ex
DecimalOutLinedInputTextField(
    modifier = modifier.weight(1f),
    hint = stringResource(R.string.IncomeHint),
    label = stringResource(R.string.IncomeLabel),
    onValueChange = {
        income = it
    }
)
 * */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DecimalOutLinedInputTextField(
    modifier: Modifier = Modifier,
    label: String,
    labelFontSize: TextUnit = FontSize.fontSizeSP,
    onValueChange: (Float) -> Unit,
    hint: String = "",
    initialValue: String = "",
) {
    var text by remember { mutableStateOf(initialValue) }
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = modifier,
        value = text,
        singleLine = true,
        onValueChange = {
            val res = it.replace("-","").replace(" ", "")
            text = res
            when (res.isBlank()) {
                true -> onValueChange(0f)
                false -> onValueChange(res.toFloat())
            }
        },
        label = {
            Text(
                maxLines = 2,
                text = label,
                fontSize = labelFontSize,
            )
        },
        placeholder = { Text(hint) },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Decimal,
        ),
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
    )
}
